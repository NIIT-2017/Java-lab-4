import com.google.gson.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class ProjectItem {
    //Employees who work on the project
    private HashSet<Integer> executioners = new HashSet<>();
    private String title;
    private int cost;
    public ProjectItem(String title, int cost){
        this.title = title;
        this.cost = cost;
    }
    public ProjectItem(String title, int cost, HashSet<Integer> executioners){
        this(title, cost);
        this.executioners = executioners;
    }

    public String getTitle() {
        return title;
    }

    public Set<Integer> getExecutioners(){
        return Collections.unmodifiableSet(executioners);
    }
    public int getCost() {
        return cost;
    }
    //Adds the employee to the project staff
    public boolean addExecutioner(int id){
        return executioners.add(id);
    }
    //Calculates the project work part of the employee
    public float workPart(int id){
        if (!executioners.contains(id))
            return 0f;
        else{
            int sumWorktime = sumWorktime();
            if (sumWorktime != 0)
                return (float) HR.getEmployee(id).getWorktime() / sumWorktime();
            else
                return 0f;
        }
    }
    //Calculates the summary worktime of project staff
    private int sumWorktime(){
        int sum = 0;
        for (int employeeID : executioners){
            sum += HR.getEmployee(employeeID).getWorktime();
        }
        return sum;
    }
}

class HR{
    //List of all employees
    private static HashMap<Integer, Employee> staff = new HashMap<>();
    public static boolean addStaff(Employee employee){
        if (staff.containsKey(employee.getId()))
            return false;
        else{
            staff.put(employee.getId(), employee);
            return true;
        }
    }
    public static Map<Integer, Employee> getEmployeeList(){
        return Collections.unmodifiableMap(staff);
    }
    public static Employee getEmployee(int id){
        return staff.get(id);
    }
    //Sets of head position and permissible subordinate positions
    private static HashMap<Class<? extends Heading>, HashSet<Class<? extends Employee>>> listOfSubordinateStaff;
    static {
        listOfSubordinateStaff = new HashMap<>();
        listOfSubordinateStaff.put(SeniorManager.class, new HashSet<>(Arrays.asList(ProjectManager.class, TeamLead.class)));
        listOfSubordinateStaff.put(ProjectManager.class, new HashSet<>(Arrays.asList(Manager.class)));
        listOfSubordinateStaff.put(TeamLead.class, new HashSet<>(Arrays.asList(Programmer.class, Tester.class)));
    }
    //Checks if the the head is allowed to manage the employee
    public static boolean isValidStaff(Heading head, int id){
        return listOfSubordinateStaff.get(head.getClass()).contains(staff.get(id).getClass());
    }
    //Gets information for each employee
    public static void getInformation(){
        System.out.println("            Name|    Worktime|    Payment|");
        System.out.println("------------------------------------------");
        for (Map.Entry<Integer, Employee> employee : staff.entrySet()){
            System.out.format("%15s | %10d | %10.2f|\n", employee.getValue().getName(), employee.getValue().getWorktime(), employee.getValue().getPayment());
        }
    }
}

class Accounting {
    //Part of an project cost that are separated between project staff
    private static float baseProjectPart = 0.3f;
    //List of all projects
    private static HashMap<String, ProjectItem> projects = new HashMap<>();

    public static boolean addProject(ProjectItem projectItem){
        if (projects.containsKey(projectItem.getTitle()))
            return false;
        else {
            projects.put(projectItem.getTitle(), projectItem);
            return true;
        }
    }
    public static Map<String, ProjectItem> getProjectList(){
        return Collections.unmodifiableMap(projects);
    }
    private static int projectCost(String title){
        if (projects.containsKey(title))
            return projects.get(title).getCost();
        else
            return 0;
    }
    //Allows to add the employee to the project if checks are passed
    public static boolean addToProject(int id, String title){
        if (HR.getEmployee(id) instanceof Project && projects.containsKey(title))
            return projects.get(title).addExecutioner(id);
        else
            return false;
    }
    //Calculates employee's part of the project cost
    public static float projectCut(int id, String title){
        Employee person = HR.getEmployee(id);
        float part = 0f;
        if (person instanceof Project && projectCost(title) != 0)
            part = positionProjectPart((Project) person);
        else
            return 0f;

        return projects.get(title).getCost() * projects.get(title).workPart(id) * part * baseProjectPart;
    }
    //Gives position bonus for calculating part of the project cost for the position
    private static float positionProjectPart(Project person){
        if (person.getClass().equals(SeniorManager.class))
            return  1.15f;
        else if (person.getClass().equals(ProjectManager.class))
            return 1.12f;
        else if (person.getClass().equals(TeamLead.class))
            return 1.1f;
        else if (person.getClass().equals(Manager.class))
            return 1.07f;
        else if (person.getClass().equals(Programmer.class))
            return 1.03f;
        else if (person.getClass().equals(Tester.class))
            return 1.01f;
        else
            return 0f;
    }
    //Gives heading bonus for managing of the employee
    public static float headPremium(int id){
        Employee person = HR.getEmployee(id);
        if (person.getClass().equals(ProjectManager.class))
            return 0.1f;
        else if (person.getClass().equals(TeamLead.class))
            return 0.1f;
        else if (person.getClass().equals(Manager.class))
            return 0.02f;
        else if (person.getClass().equals(Programmer.class))
            return 0.03f;
        else if (person.getClass().equals(Tester.class))
            return 0.01f;
        else
            return 0f;
    }
}
//Contains heading functionality
class HeadingJob{
    public HashSet<Integer> subordinateStaff;

    public HeadingJob(){
        subordinateStaff = new HashSet<>();
    }
    public HeadingJob(HashSet<Integer> subordinateStaff){
        this.subordinateStaff = subordinateStaff;
    }
    public float moneyForHeading(int worktime) {
        float k = 1;
        for (int employeeID : subordinateStaff)
            k += Accounting.headPremium(employeeID);
        return k * worktime;
    }
    public boolean setSubordinateStaff(Heading head, int id) {
        return (HR.isValidStaff(head, id)) && subordinateStaff.add(id);
    }
    public Set<Integer> getSubordinateStaff(){
        return Collections.unmodifiableSet(subordinateStaff);
    }
}
//Contains functionality of project job
class ProjectJob {
    public HashSet<String> projects;

    public ProjectJob(){
        projects = new HashSet<>();
    }
    public ProjectJob(HashSet<String> projects){
        this.projects = projects;
    }
    public float moneyForProjects(int id) {
        float money = 0;
        for (String projectTitle : projects)
            money += Accounting.projectCut(id, projectTitle);
        return money;
    }
    public boolean setProject(int id, String projectTitle) {
        if (Accounting.addToProject(id, projectTitle))
            return projects.add(projectTitle);
        else
            return false;
    }
    public Set<String> getProjects(){
        return Collections.unmodifiableSet(projects);
    }
}
//Contains functionality of worktime job
class WorktimeJob{
    public float moneyForWorktime(int base, int worktime){
        return base * worktime;
    }
}
//Save and load the progress
class SaveLoad{
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    //save the progress
    public static void save(){
        try{
            BufferedWriter bw = Files.newBufferedWriter(Paths.get(SaveLoad.class.getResource("Data").toURI()));
            Map<String, ProjectItem> projects = Accounting.getProjectList();
            Map<Integer, Employee> staff = HR.getEmployeeList();
            bw.write(SaveLoad.getHeader(projects.size(), staff.size()));
            bw.newLine();
            //save projects
            for (Map.Entry<String, ProjectItem> project : projects.entrySet()){
                bw.write(SaveLoad.getJSONProject(project.getValue()));
                bw.newLine();
            }
            //save employees
            for (Map.Entry<Integer, Employee> employee : staff.entrySet()){
                bw.write(SaveLoad.getJSONEmployee(employee.getValue()));
                bw.newLine();
            }
            bw.close();
        } catch(URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }
    }
    //load the progress
    public static void load(){
        JsonStreamParser jsonStreamParser = new JsonStreamParser(new InputStreamReader(SaveLoad.class.getResourceAsStream("Data")));
        JsonObject header = jsonStreamParser.next().getAsJsonObject();
        int numberOfProject = header.get("numberOfProjects").getAsInt();
        int numberOfEmployee = header.get("numberOfEmployees").getAsInt();
        //load projects
        for (int i = 0; i < numberOfProject; i++){
            loadProject(jsonStreamParser.next().getAsJsonObject());
        }
        //load employees
        for (int i = 0; i < numberOfEmployee; i++){
            loadEmployee(jsonStreamParser.next().getAsJsonObject());
        }
    }
    //make the header which contains number of projects and employees
    private static String getHeader(int numberOfProjects, int numberOfEmployees){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("numberOfProjects", numberOfProjects);
        jsonObject.addProperty("numberOfEmployees", numberOfEmployees);
        return jsonObject.toString();
    }
    //make JSON representation of the project
    private static String getJSONProject(ProjectItem projectItem){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("title", projectItem.getTitle());
        jsonObject.addProperty("cost", projectItem.getCost());
        jsonObject.add("executioners", gson.toJsonTree(projectItem.getExecutioners()).getAsJsonArray());
        return jsonObject.toString();
    }
    //make JSON representation of the employee
    private static String getJSONEmployee(Employee employee){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("position", employee.getClass().getSimpleName());
        jsonObject.addProperty("name", employee.getName());
        jsonObject.addProperty("id", employee.getId());
        jsonObject.addProperty("worktime", employee.getWorktime());
        if (employee instanceof WorkTime)
            jsonObject.addProperty("base", ((WorkTime) employee).getBase());
        if (employee instanceof Project)
            jsonObject.add("projects", gson.toJsonTree(((Project) employee).getProjects()).getAsJsonArray());
        if (employee instanceof Heading)
            jsonObject.add("sub_staff", gson.toJsonTree(((Heading) employee).getSubordinateStaff()).getAsJsonArray());
        return jsonObject.toString();
    }
    //make the project from JSON
    private static void loadProject(JsonObject JSONProject){
        Type tokenHS_Int = new TypeToken<HashSet<Integer>>(){}.getType();
        HashSet<Integer> execID = gson.fromJson(JSONProject.get("executioners").getAsJsonArray(), tokenHS_Int);
        ProjectItem projectItem = new ProjectItem(JSONProject.get("title").getAsString(), JSONProject.get("cost").getAsInt(), execID);
        Accounting.addProject(projectItem);
    }
    //make the employee from JSON
    private static void loadEmployee(JsonObject JSONEmployee){
        String position = JSONEmployee.get("position").getAsString();
        Employee employee = null;
        int id = JSONEmployee.get("id").getAsInt();
        String name = JSONEmployee.get("name").getAsString();
        Type tokenHS_Int = new TypeToken<HashSet<Integer>>(){}.getType();
        Type tokenHS_Str = new TypeToken<HashSet<String>>(){}.getType();
        HashSet<Integer> hs_Int;
        HashSet<String> hs_Str;
        if (JSONEmployee.has("projects")){
            hs_Str = gson.fromJson(JSONEmployee.get("projects").getAsJsonArray(), tokenHS_Str);
        } else
            hs_Str = new HashSet<String>();
        if (JSONEmployee.has("sub_staff")){
            hs_Int = gson.fromJson(JSONEmployee.get("sub_staff").getAsJsonArray(), tokenHS_Int);
        } else
            hs_Int = new HashSet<Integer>();
        if (position.equals(Driver.class.getSimpleName())){
            employee = new Driver(id, name, JSONEmployee.get("base").getAsInt());
        } else if (position.equals(Cleaner.class.getSimpleName())){
            employee = new Cleaner(id, name, JSONEmployee.get("base").getAsInt());
        } else if (position.equals(Tester.class.getSimpleName())){
            employee = new Tester(id, name, JSONEmployee.get("base").getAsInt(), hs_Str);
        } else if (position.equals(Programmer.class.getSimpleName())){
            employee = new Programmer(id, name, JSONEmployee.get("base").getAsInt(), hs_Str);
        } else if (position.equals(TeamLead.class.getSimpleName())){
            employee = new TeamLead(id, name, JSONEmployee.get("base").getAsInt(), hs_Int, hs_Str);
        } else if (position.equals(Manager.class.getSimpleName())){
            employee = new Manager(id, name, hs_Str);
        } else if (position.equals(ProjectManager.class.getSimpleName())){
            employee = new ProjectManager(id, name, hs_Int, hs_Str);
        } else if (position.equals(SeniorManager.class.getSimpleName())){
            employee = new SeniorManager(id, name, hs_Int, hs_Str);
        }
        if (employee != null) {
            employee.setWorktime(JSONEmployee.get("worktime").getAsInt());
            HR.addStaff(employee);
        }
    }
}