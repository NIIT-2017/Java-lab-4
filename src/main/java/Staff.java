import java.util.ArrayList;
import java.io.FileReader;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

public class Staff {
    private ArrayList<Projects> projects;
    private ArrayList<Employee> employees;

    public Staff (String fileStaff, String fileProjects){
        createProjects(fileProjects);
        createEmployees(fileStaff);
    }

    public Projects findProjectByName(String projectName){
        for (Projects project: projects){
            if (project.getName().equals(projectName)){
                return project;
            }
        }
        System.out.println("Wrong project name. Check your data!");
        return null;
    }

    public int calcAllProjectsBudget(){
        int result = 0;
        for (Projects project: projects){
            result += project.getBudget();
        }
        if (0 >= result){
            System.out.println("Error! Project budgets are uncorrect.");
        }
        return result;
    }

    //factory
    public void createEmployees(String fileStaff){
        employees = new ArrayList<Employee>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(fileStaff)){
            JSONObject object = (JSONObject)parser.parse(reader);
            JSONArray employeesArr = (JSONArray) object.get("employees");
            Iterator employeesIterator = employeesArr.iterator();

            while(employeesIterator.hasNext()) {
                JSONObject emp = (JSONObject) employeesIterator.next();
                int id = ((Long) emp.get("id")).intValue();
                String fio = (String) emp.get("fio");
                String position = (String) emp.get("position");
                int rate = 0;
                String projectName = null;
                Double part = 0.0;
                int projectBudget = 0;
                int subs = 0;
                Employee employee = null;
                switch (position){
                    case "Programmer":
                        rate = ((Long) emp.get("rate")).intValue();
                        projectName = (String) emp.get("project");
                        part = (Double) emp.get("part");
                        projectBudget = findProjectByName(projectName).getBudget();
                        employee = new Programmer(id, fio, rate, projectBudget, part);
                        break;

                    case "Tester":
                        rate = ((Long) emp.get("rate")).intValue();
                        projectName = (String) emp.get("project");
                        part = (Double) emp.get("part");
                        projectBudget = findProjectByName(projectName).getBudget();
                        employee = new Tester(id, fio, rate, projectBudget, part);
                        break;

                    case "Cleaner":
                        rate = ((Long) emp.get("rate")).intValue();
                        employee = new Cleaner(id, fio, rate);
                        break;

                    case "Driver":
                        rate = ((Long) emp.get("rate")).intValue();
                        employee = new Driver(id, fio, rate);
                        break;

                    case "TeamLeader":
                        rate = ((Long) emp.get("rate")).intValue();
                        projectName = (String) emp.get("project");
                        part = (Double) emp.get("part");
                        projectBudget = findProjectByName(projectName).getBudget();
                        subs = ((Long) emp.get("subs")).intValue();
                        employee = new TeamLeader(id, fio, rate, projectBudget, part, subs);
                        break;

                    case "ProjectManager":
                        projectName = (String) emp.get("project");
                        part = (Double) emp.get("part");
                        projectBudget = findProjectByName(projectName).getBudget();
                        subs = ((Long) emp.get("subs")).intValue();
                        employee = new ProjectManager(id, fio, projectBudget, part, subs);
                        break;

                    case "SeniorManager":
                        projectName = (String) emp.get("project");
                        part = (Double) emp.get("part");
                        projectBudget = calcAllProjectsBudget();
                        subs = ((Long) emp.get("subs")).intValue();
                        employee = new SeniorManager(id, fio, projectBudget, part, subs);
                        break;

                    default:
                        System.out.println("Error! Wrong position in file with employees.");
                        return;
                }
                employees.add(employee);
            }
        }
        catch (ParseException | IOException e){
            e.printStackTrace();
        }
    }

    public void createProjects(String fileProjects){
        projects = new ArrayList<Projects>();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(fileProjects)){
            JSONObject object = (JSONObject)parser.parse(reader);
            JSONArray projectsArr = (JSONArray) object.get("projects");
            Iterator projectsIterator = projectsArr.iterator();
            String name = null;
            int budget = 0;
            while(projectsIterator.hasNext()) {
                JSONObject pr = (JSONObject) projectsIterator.next();
                name = (String) pr.get("name");
                budget = ((Long) pr.get("budget")).intValue();
                Projects project = new Projects (name, budget);
                projects.add(project);
            }
        }
        catch (ParseException | IOException e){
            e.printStackTrace();
        }
    }

    //this method is setting worktime for all employees and calculate their salary. Of course in extended version of
    //program it will be better to create opportunity to set individual worktime for each employee on the basis
    //of data from JSON file with employees. But it was not necessary according to this task's condition.
    public void calcPaymentForAllStaff(int worktime){
        for (Employee emp: employees){
            emp.setWorktime(worktime);
            emp.setPayment();
        }
    }

    public void printData(){
        for (Employee emp: employees){
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getPosition() + " отработал " +
                    emp.getWorktime() + " часов. Зарплата " + emp.getPayment());
            //System.out.printf("%d \t %s \tотработал %d  часов. \tЗарплата %d\n", emp.getId(), emp.getName(),
                    //emp.getWorktime(), emp.getPayment());
        }
    }
}
