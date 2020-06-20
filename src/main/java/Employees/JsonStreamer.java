package Employees;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;

public  class JsonStreamer {
    public static <T> void writeObjectToFile(T object,String outputFileName) throws Exception
    {
        ObjectMapper objectMapper=new ObjectMapper();
        String jsonString=objectMapper.writeValueAsString(object);
        jsonString=jsonString.substring(1,jsonString.length()-1);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = Paths.get(classLoader.getResource(outputFileName).toURI()).toFile();
        PrintWriter writer=new PrintWriter(new FileWriter(file));
        writer.write(jsonString);
        writer.close();
    }
    public static JSONObject getJsonObjectFromFile(String inputFileName) throws Exception
    {
        JSONParser parser = new JSONParser();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = Paths.get(classLoader.getResource(inputFileName).toURI()).toFile();
        FileReader fileReader=new FileReader(file);
        return (JSONObject) parser.parse(fileReader);
    }
    public static Project readProjectFromJsonObject(JSONObject jsonObject) throws Exception
    {
        Gson gson=new Gson();
        JSONParser parser = new JSONParser();
        ProjectManager projectManager=gson.fromJson(((JSONObject)parser.parse(jsonObject.get("projectManager").toString())).toString()
                ,ProjectManager.class);
        Project project=new Project((String) jsonObject.get("title"),projectManager
                ,(long)jsonObject.get("budget"),(long)jsonObject.get("participationPoints"));
        projectManager.setProject(project);
        projectManager.setSalaryPerSubordinate(((long)((JSONObject)jsonObject.get("projectManager")).get("salaryPerSubordinate")));
        JSONArray jsonArrayEmployees=(JSONArray) jsonObject.get("employees");
        Object []employeesArray=jsonArrayEmployees.toArray();
        for(int i=1;i<employeesArray.length;i++)
        {
            JSONObject jsonObjectEmployee=(JSONObject)employeesArray[i];
            String className= (String)jsonObjectEmployee.get("class");
            Employee employee=readEmployeeFromJson(jsonObjectEmployee,project);
        }
        JSONObject jsonObjectParticipationPoints=(JSONObject) jsonObject.get("hashMapParticipationPoints");
        for(int i=0;i<project.getEmployees().size();i++)
        {
            long employeeId=project.getEmployees().get(i).getId();
            project.addParticipationPoint(employeeId,(long)jsonObjectParticipationPoints.get(String.valueOf(employeeId)));
        }
        return project;
    }
    public static  Project readProjectFromFile(String inputFileName) throws Exception
    {
        JSONObject jsonObject = getJsonObjectFromFile(inputFileName);
        return readProjectFromJsonObject(jsonObject);
    }
    public static Employee readEmployeeFromJson(JSONObject jsonObjectEmployee,Project project)
    {
        String className= (String)jsonObjectEmployee.get("class");
        Employee employee=null;
        switch (className)
        {
            case "Employees.Engineer":
                employee=new Engineer((long) jsonObjectEmployee.get("id"),(String) jsonObjectEmployee.get("name"),(String)jsonObjectEmployee.get("surname")
                        ,(long)jsonObjectEmployee.get("salaryForHour"));
                break;
            case "Employees.Tester":
                employee=new Tester((long) jsonObjectEmployee.get("id"),(String) jsonObjectEmployee.get("name"),(String)jsonObjectEmployee.get("surname")
                        ,(long)jsonObjectEmployee.get("salaryForHour"));
                break;
            case "Employees.Programmer":
                employee=new Programmer((long) jsonObjectEmployee.get("id"),(String) jsonObjectEmployee.get("name"),(String)jsonObjectEmployee.get("surname")
                        ,(long)jsonObjectEmployee.get("salaryForHour"));
                break;
            case "Employees.Manager":
                employee=new Manager((long) jsonObjectEmployee.get("id"),(String) jsonObjectEmployee.get("name"),(String)jsonObjectEmployee.get("surname"));
                break;
            case "Employees.Driver":
                employee=new Driver((long) jsonObjectEmployee.get("id"),(String) jsonObjectEmployee.get("name"),(String)jsonObjectEmployee.get("surname"),
                        (long)jsonObjectEmployee.get("salaryForHour"));
                break;
            case "Employees.Cleaner":
                employee=new Cleaner((long) jsonObjectEmployee.get("id"),(String) jsonObjectEmployee.get("name"),(String)jsonObjectEmployee.get("surname"),
                        (long)jsonObjectEmployee.get("salaryForHour"));
                break;

        }
        setEmployee(employee,project,jsonObjectEmployee);
        return employee;
    }
    public static Company readCompanyFromFile(String inputFileName) throws Exception
    {
        JSONObject jsonObjectCompany=getJsonObjectFromFile(inputFileName);
        Company company= new Company();
        company.setTitle((String) jsonObjectCompany.get("title"));
        JSONArray jsonArrayProjects=(JSONArray) jsonObjectCompany.get("projects");
        for(Object jsonObjectProject : jsonArrayProjects)
            company.addProject(readProjectFromJsonObject((JSONObject) jsonObjectProject));
        JSONArray jsonArrayPersonel=(JSONArray)jsonObjectCompany.get("personal");
        for(Object jsonObjectPeson : jsonArrayPersonel)
        {
            Personal personal=(Personal) readEmployeeFromJson((JSONObject) jsonObjectPeson, null);
            personal.setWorkTime((long)((JSONObject) jsonObjectPeson).get("workTime"));
            company.addPersonal(personal);
        }
        return  company;
    }
    private static void setEmployee(Employee employee,Project project,JSONObject jsonObjectEmployee)
    {
        long managerId=(long)jsonObjectEmployee.get("managerId");
        if(managerId!=-1)
            employee.setManager((Manager) project.getEmployeeById(managerId));
        if(project!=null)
            employee.setProject(project);
        if(employee instanceof WorkTime)
        {
            long workTime = (long) jsonObjectEmployee.get("workTime");
            employee.setWorkTime(workTime);
        }
        if(employee instanceof Heading)
        {
            long salaryForHeadingPerEmployee=(long)jsonObjectEmployee.get("salaryForHeading");
            ((Heading)employee).setSalaryPerSubordinate(salaryForHeadingPerEmployee);
        }
    }
}
