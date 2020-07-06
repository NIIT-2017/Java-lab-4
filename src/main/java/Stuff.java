import java.io.File;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

public class Stuff {
//fields
    private ArrayList<Project> allProjects;
    private ArrayList<Employee> allEmployees;
//constructor
    public Stuff (){
        this.allProjects = new ArrayList<>();
        this.allEmployees = new ArrayList<>();
    }
    //getters
    public ArrayList<Project> getAllProjects(){ return this.allProjects; }
    public ArrayList<Employee> getAllEmployees(){ return this.allEmployees; }
//private methods
    private Project findProject(String projectName){
        Project resultProject=null;
        for (Project project : allProjects) {
            if (project.getProjectName().equals(projectName)){
                resultProject = project;
                break;
            }
            else
                resultProject = null;
        }
        if (resultProject == null)
            System.out.println("Project "+projectName+" not found");
        return resultProject;
    }
    private POSITIONS getPosition(Object obj){return POSITIONS.valueOf(((JSONObject) obj).get("position").toString());}
    private int getID(Object obj){return Integer.parseInt(((JSONObject) obj).get("id").toString());}
    private String getName(Object obj){return ((JSONObject) obj).get("name").toString();}
    private double getProjectPart(Object obj){return Double.parseDouble(((JSONObject) obj).get("projectPart").toString());}
    private Project getProject(Object obj){
        return findProject( ((JSONObject) obj).get("projects").toString() );
    }
    private double getBase(Object obj){
        return Double.parseDouble(((JSONObject) obj).get("base").toString());
    }
    private int getWorktime(Object obj){
        return Integer.parseInt(((JSONObject) obj).get("worktime").toString());
    }
    private String getTeamLeaderName(Object obj){
        return ((JSONObject) obj).get("teamleader").toString();
    }
//public methods
    public void getStuffFromJson(String fileDirection){
        try{
            File jsfile = new File(fileDirection);
            String content = FileUtils.readFileToString(jsfile,"utf-8");
            JSONObject jsList = new JSONObject(content);
            JSONArray jsAllProjects = (JSONArray)jsList.get("allProjects");
            JSONArray jsAllEmployees = (JSONArray)jsList.get("allEmployees");
            for (Object obj : jsAllProjects) {
                Project project = new Project(((JSONObject) obj).get("name").toString(),
                        Double.parseDouble(((JSONObject) obj).get("cost").toString()));
                this.allProjects.add(project);
            }
            for (Object obj : jsAllEmployees) {
                switch (getPosition(obj)){
                    case SeniorManager:{
                        SeniorManager SM = new SeniorManager(getID(obj),getName(obj),getProjectPart(obj));
                        SM.setProjects(this.allProjects);
                        SM.setPosition(POSITIONS.SeniorManager);
                        this.allEmployees.add(SM);
                        break;
                    }
                    case ProjectManager:{
                        ProjectManager PM = new ProjectManager(getID(obj),getName(obj),getProjectPart(obj));
                        PM.setProject(getProject(obj));
                        PM.getProject().setProjectManager(PM);
                        PM.setPosition(POSITIONS.ProjectManager);
                        this.allEmployees.add(PM);
                        break;
                    }
                    case Manager:{
                        Manager M = new Manager(getID(obj),getName(obj),getProjectPart(obj));
                        M.setProject(getProject(obj));
                        M.getProject().getProjectTeammates().add(M);
                        M.setPosition(POSITIONS.Manager);
                        this.allEmployees.add(M);
                        break;
                    }
                    case TeamLeader:{
                        TeamLeader TL = new TeamLeader(getID(obj),getName(obj),
                                                       getBase(obj),getWorktime(obj),
                                                       getProjectPart(obj));
                        TL.setProject(getProject(obj));
                        TL.getProject().getProjectTeammates().add(TL);
                        TL.setPosition(POSITIONS.TeamLeader);
                        this.allEmployees.add(TL);
                        break;
                    }
                    case Programmer:{
                        Programmer P = new Programmer(getID(obj),getName(obj),
                                                      getBase(obj),getWorktime(obj),
                                                      getProjectPart(obj));
                        P.setProject(getProject(obj));
                        P.getProject().getProjectTeammates().add(P);
                        P.setTeamLeaderName(getTeamLeaderName(obj));
                        P.setPosition(POSITIONS.Programmer);
                        this.allEmployees.add(P);
                        break;
                    }
                    case Tester:{
                        Tester T = new Tester(getID(obj),getName(obj),
                                              getBase(obj),getWorktime(obj),
                                              getProjectPart(obj));
                        T.setProject(getProject(obj));
                        T.getProject().getProjectTeammates().add(T);
                        T.setTeamLeaderName(getTeamLeaderName(obj));
                        T.setPosition(POSITIONS.Tester);
                        this.allEmployees.add(T);
                        break;
                    }
                    case Cleaner:{
                        Cleaner C = new Cleaner(getID(obj), getName(obj), getBase(obj), getWorktime(obj));
                        C.setPosition(POSITIONS.Cleaner);
                        this.allEmployees.add(C);
                        break;
                    }
                    case Driver:{
                        Driver D = new Driver(getID(obj), getName(obj), getBase(obj), getWorktime(obj));
                        D.setPosition(POSITIONS.Driver);
                        this.allEmployees.add(D);
                    }
                }
            }
        }
        catch (NoSuchFileException e){
            System.out.println("File "+"'"+fileDirection+"'"+" not found");
            System.exit(1);
        }
        catch (InvalidPathException e){
            System.out.println("Wrong direction "+"'"+fileDirection+"'");
            System.exit(1);
        }
        catch (IOException e) {
            System.out.println("File "+"'"+fileDirection+"'"+" reading error");
            System.exit(1);
        }
    }

    public void createHeading(){
        for (Employee employee : this.allEmployees) {
            switch (employee.getPosition()){
                case SeniorManager: {
                    for (Employee emp : this.allEmployees)
                        if (!(emp.equals(employee)))
                            ((SeniorManager) employee).getSubordinates().add(emp);
                    break;
                }
                case ProjectManager: {
                    ((ProjectManager) employee).setSubordinates(
                            ((ProjectManager) employee).getProject().getProjectTeammates());
                    break;
                }
                case TeamLeader: {
                    for (Employee emp : this.allEmployees) {
                        switch (emp.getPosition()) {
                            case Programmer: {
                                if (((Programmer) emp).getTeamLeaderName().equals(employee.getName()))
                                    ((TeamLeader) employee).getTeammates().add(emp);
                                break;
                            }
                            case Tester: {
                                if (((Tester) emp).getTeamLeaderName().equals(employee.getName()))
                                    ((TeamLeader) employee).getTeammates().add(emp);
                            }
                        }
                    }
                }
            }
        }
    }

    public void calcPayments(){
        for (Employee emp : this.allEmployees)
            emp.calcPayment();
    }

    public void outputStuff(PrintStream ps){
        String format1 = "%1$-4s|%2$-20s|%3$-15s|%4$-5s|%5$-9s\n";
        ps.format(format1,"ID","NAME","POSITION","WTIME","PAYMENT");
        for (Employee emp : this.allEmployees) {
            ps.format(format1,emp.getID(),emp.getName(),emp.getPosition(), emp.getWorktime(),emp.getPayment());
        }
    }
}
