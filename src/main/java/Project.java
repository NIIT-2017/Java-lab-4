import java.util.ArrayList;

public class Project {
//fields
    private String projectName;
    private double projectCost;
    private ProjectManager projectManager;
    private ArrayList<Employee> projectTeammates;
//constructor
    public Project (String projectName, double projectCost){
        this.projectName = projectName;
        this.projectCost = projectCost;
        this.projectManager = null;
        this.projectTeammates = new ArrayList<>();
    }
//getters
    public String getProjectName(){ return  this.projectName; }
    public double getProjectCost(){ return this.projectCost; }
    public ArrayList<Employee> getProjectTeammates(){ return this.projectTeammates; }
//setters
    public void setProjectManager(ProjectManager projectManager){ this.projectManager = projectManager; }
}
