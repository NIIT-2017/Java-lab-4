import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Company {

    static private int countEmployee=0; //for id
    ArrayList <Employee> company;

    public Company()
    {
        this.company = new ArrayList<>();
    }

    public int getCountEmployee(){
        return countEmployee;
    }

    public int companyMade(String nameFile){
        int countEmployeeBefore=countEmployee;
        List <String> allPosition = Arrays.asList(new String[] {"Clear","Driver","Programmer","Tester", "TeamLeader","Manager", "ProjectManager", "SeniorManager"});
        int index=0;

        JSONParser parser = new JSONParser();
        try{
            //URL resource=Company.class.getResource(nameFile);
            //File file= Paths.get(resource.toURI()).toFile();
            //FileReader fr= new FileReader(file);

            InputStream inputStream = getClass().getResourceAsStream(nameFile);
            String fr = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

            JSONArray companyAll = (JSONArray)parser.parse(fr);
            for(Object oneEmployee : companyAll) {
                JSONObject employee = (JSONObject) oneEmployee;
                String position = (String) employee.get("position");
                long id = (long) employee.get("id");
                String name = (String) employee.get("name");

                for (int i = 0; i < allPosition.size(); i++) {
                    if (position.equals(allPosition.get(i))) {
                        index = i;
                        break;
                    }
                }
                switch (index) {
                    case 0:
                        double base=(double)employee.get("base");
                        company.add(new Clear(id, name,base));
                        countEmployee++;
                        break;

                    case 1:
                        base=(double)employee.get("base");
                        long countWeekendTripsHours = (long) employee.get("countWeekendTripsHours");
                        company.add(new Driver(id, name,base, (int)countWeekendTripsHours));
                        countEmployee++;
                        break;

                    case 2:
                        base=(double)employee.get("base");
                        HashMap<String, Double> mapProjectsPercent=new HashMap <String, Double>();
                        JSONArray forMapProjectPercent = (JSONArray) employee.get("mapProjectPercent");
                        for (Object oneProject : forMapProjectPercent) {
                            JSONObject projectOne = (JSONObject) oneProject;
                            String project = (String) projectOne.get("project");
                            double percent = (double) projectOne.get("percent");
                            mapProjectsPercent.put(project, percent);
                        }

                        company.add(new Programmer(id, name,base,mapProjectsPercent));
                        countEmployee++;
                        break;

                    case 3:
                        base=(double)employee.get("base");
                        mapProjectsPercent=new HashMap <String, Double>();
                        forMapProjectPercent = (JSONArray) employee.get("mapProjectPercent");
                        for (Object oneProject : forMapProjectPercent) {
                            JSONObject projectOne = (JSONObject) oneProject;

                            String project = (String) projectOne.get("project");
                            double percent = (double) projectOne.get("percent");
                            mapProjectsPercent.put(project, percent);
                        }
                        double percentCode=(double)employee.get("percentCode");
                        company.add(new Tester(id, name,base,mapProjectsPercent,percentCode));
                        countEmployee++;
                        break;

                    case 4:
                        base=(double)employee.get("base");
                        mapProjectsPercent=new HashMap <String, Double>();
                        forMapProjectPercent = (JSONArray) employee.get("mapProjectPercent");
                        for (Object oneProject : forMapProjectPercent) {
                            JSONObject projectOne = (JSONObject) oneProject;

                            String project = (String) projectOne.get("project");
                            double percent = (double) projectOne.get("percent");
                            mapProjectsPercent.put(project, percent);
                        }
                        long personal = (long) employee.get("personal");
                        company.add(new TeamLeader(id, name, base, mapProjectsPercent,(int)personal));
                        countEmployee++;
                        break;

                    case 5:
                        mapProjectsPercent=new HashMap <String, Double>();
                        forMapProjectPercent = (JSONArray) employee.get("mapProjectPercent");
                        for (Object oneProject : forMapProjectPercent) {
                            JSONObject projectOne = (JSONObject) oneProject;

                            String project = (String) projectOne.get("project");
                            double percent = (double) projectOne.get("percent");
                            mapProjectsPercent.put(project, percent);
                        }
                        company.add(new Manager(id, name,mapProjectsPercent));
                        countEmployee++;
                        break;

                    case 6:
                        mapProjectsPercent=new HashMap <String, Double>();
                        forMapProjectPercent = (JSONArray) employee.get("mapProjectPercent");
                        for (Object oneProject : forMapProjectPercent) {
                            JSONObject projectOne = (JSONObject) oneProject;

                            String project = (String) projectOne.get("project");
                            double percent = (double) projectOne.get("percent");
                            mapProjectsPercent.put(project, percent);
                        }
                        personal = (long) employee.get("personal");
                        company.add(new ProjectManager(id, name,mapProjectsPercent,(int)personal));
                        countEmployee++;
                        break;

                    case 7:
                        mapProjectsPercent=new HashMap <String, Double>();
                        forMapProjectPercent = (JSONArray) employee.get("mapProjectPercent");
                        for (Object oneProject : forMapProjectPercent) {
                            JSONObject projectOne = (JSONObject) oneProject;
                            String project = (String) projectOne.get("project");
                            double percent = (double) projectOne.get("percent");
                            mapProjectsPercent.put(project, percent);
                        }
                        personal = (long) employee.get("personal");
                        company.add(new SeniorManager(id, name,mapProjectsPercent,(int)personal));
                        countEmployee++;
                        break;
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return countEmployee-countEmployeeBefore;
    }

    public void giveWorkTime(int minWorkTime){
        Random random = new Random(47);

        Iterator it=company.iterator();
        while(it.hasNext()){
            int randomTime = random.nextInt(50)+minWorkTime; //[hours]  rage minWorkTime ... minWorkTime+50,  hours - for 1 week
            ((Employee) it.next()).setWorkTime(randomTime);   //it is more readable than ((Employee)it.next()).setWorkTime(workTime);
        }
    }

    public void calcPaymentForCompany() {
        for (Employee emp : company) {
            emp.calc();
        }
    }

    public void getAllPaymentToConsole(){
        System.out.println("         FIO                        Position        WorkTime,[hours]     Payment, [rub]  ");
        for(Employee emp : company)
            System.out.printf("%-35s %-15s     %-10d   %15.3f\n",emp.getName(),emp.toString() ,emp.getWorkTime(),emp.getPayment());
    }

    public void getAllPaymentToFile(){

        String timeStamp = new SimpleDateFormat("dd_MM_yyyy").format(Calendar.getInstance().getTime()); //for nameFile
        String nameFile = "AllPayment_" + timeStamp + ".json"; //for user convenience

        JSONArray allCompanyJson = new JSONArray();
        for(Employee oneEmp : company){
            JSONObject objEmpJson = new JSONObject();
            objEmpJson.put("fio", oneEmp.getName());
            objEmpJson.put("workTime", oneEmp.getWorkTime());
            objEmpJson.put("payment", oneEmp.getPayment());
            objEmpJson.put("position", oneEmp.toString());
            allCompanyJson.add(objEmpJson);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nameFile)))
        {
            bw.write(allCompanyJson.toString());}
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args){

        Company companyMain= new Company();
        companyMain.companyMade("/company.json");
        companyMain.giveWorkTime(15);
        companyMain.calcPaymentForCompany();
        companyMain.getAllPaymentToConsole();
        companyMain.getAllPaymentToFile();
    }
}

