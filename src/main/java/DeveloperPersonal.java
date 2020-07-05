import java.util.ArrayList;
import java.io.FileReader;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

public class DeveloperPersonal {

    private ArrayList<Projects> projects;
    private ArrayList<Employee> personals;

    // parse staff from file
    public void PersonsParse(String fileStaff){
        personals         = new ArrayList<Employee>();
        JSONParser parser = new JSONParser();

        try (FileReader reader         = new FileReader(fileStaff)){
            JSONObject object          = (JSONObject)parser.parse(reader);
            JSONArray employeesArr     = (JSONArray) object.get("employees");
            Iterator employeesIterator = employeesArr.iterator();

            while(employeesIterator.hasNext()) {
                JSONObject persn     = (JSONObject) employeesIterator.next();
                int id               = ((Long) persn.get("id")).intValue();
                int rate             = 0;
                int finance           = 0;
                String projectName   = null;
                Employee persons     = null;
                String fio           = (String) persn.get("fio");
                String position      = (String) persn.get("position");

                switch (position){
                    case "Programmer":
                        rate            = ((Long) persn.get("rate")).intValue();
                        projectName     = (String) persn.get("project");
                        finance   = FindProject(projectName).getFinance();
                        persons         = new Programmer(id, fio, rate, finance);
                        break;

                    case "Tester":
                        rate            = ((Long) persn.get("rate")).intValue();
                        projectName     = (String) persn.get("project");
                        finance   = FindProject(projectName).getFinance();
                        persons         = new Tester(id, fio, rate, finance);
                        break;

                    case "Cleaner":
                        rate            = ((Long) persn.get("rate")).intValue();
                        persons         = new Cleaner(id, fio, rate);
                        break;

                    case "Driver":
                        rate            = ((Long) persn.get("rate")).intValue();
                        persons         = new Driver(id, fio, rate);
                        break;

                    case "TeamLeader":
                        rate            = ((Long) persn.get("rate")).intValue();
                        projectName     = (String) persn.get("project");
                        finance         = FindProject(projectName).getFinance();
                        persons         = new TeamLeader(id, fio, rate, finance);
                        break;

                    case "ProjectManager":
                        projectName     = (String) persn.get("project");
                        finance         = FindProject(projectName).getFinance();
                        persons         = new ProjectManager(id, fio, finance);
                        break;

                    case "SeniorManager":
                        projectName     = (String) persn.get("project");
                        finance         = CalcFinance();
                        persons         = new SeniorManager(id, fio,finance);
                        break;

                    default:
                        System.out.println("Error");
                        return;
                }
                personals.add(persons);
            }
        }
        catch (ParseException | IOException e){
            e.printStackTrace();
        }
    }

    // parse project from file
    public void ProjectParse(String fileProjects){

        projects          = new ArrayList<Projects>();
        JSONParser parser = new JSONParser();

        try (FileReader reader        = new FileReader(fileProjects)){
            JSONObject object         = (JSONObject)parser.parse(reader);
            JSONArray arr     = (JSONArray) object.get("projects");
            Iterator projectsIterator = arr.iterator();
            String name               = null;
            int budget                = 0;
            while(projectsIterator.hasNext()) {
                JSONObject pr     = (JSONObject) projectsIterator.next();
                name              = (String) pr.get("name");
                budget            = ((Long) pr.get("budget")).intValue();
                Projects project  = new Projects(name, budget);
                projects.add(project);
            }
        }
        catch (ParseException | IOException e){
            e.printStackTrace();
        }
    }

    // Find all projects from file
    public Projects FindProject(String projectName){
        for (Projects pr: projects){
            if (pr.getName().equals(projectName)){
                return pr;
            }
        }
        System.out.println("Error");
        return null;
    }

    public int CalcFinance(){
        int res = 0;
        for (Projects project: projects){
            res += project.getFinance();
        }
        if (0 >= res){
            System.out.println("Error");
        }
        return res;
    }

    // Payment for all staff
    public void PaymentAll(int worktime){
        for (Employee emp: personals){
            emp.setWorktime(worktime);
            emp.setPayment();
        }
    }

    // show all the result
    public void ShowResult(){
        for (Employee persn: personals){
            System.out.println("Id: " + persn.getId() + " " + "FIO: " + persn.getName() + " " + " Position: " + persn.getPosition() + " Worked: " + persn.getWorktime() + " hours " + "Earned: " + persn.getPayment() + " rub");
        }
    }
}
