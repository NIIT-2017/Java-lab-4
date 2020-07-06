package Staff;

import java.util.ArrayList;

public class DevelopProjects {

    //fields
    private int id;
    private String title;
    private double budget;
    private ArrayList <Manager> managers = new ArrayList<>();
    private ProjectManager projectManager;
    private SeniorManager seniorManager;
    private ArrayList<Engineer> engineers = new ArrayList<>();
    private TeamLeader teamLeader;
    private enum States {AWAIT, INWORK, FINISHED, CLOSED};
    private States status;
    //---------------------------------------------------------

    //constructor
    public DevelopProjects(int id, String title, double budget, SeniorManager seniorManager) {
        this.id = id;
        this.title = title;
        this.budget = budget;
        status = States.AWAIT;
        this.seniorManager = seniorManager;
        seniorManager.setProject(this);
    }
    //---------------------------------------------------------

    //methods
    public boolean completeTheProject(){
        if (status == States.INWORK) {
            status = States.FINISHED;
            return true;
        }
        else
            return false;
    }
    public boolean closeTheProject(){
        if (status == States.FINISHED) {
            status = States.CLOSED;
            return true;
        }
        else
            return false;
    }
    public boolean isItPossibleToPay() {
        if (status == States.FINISHED)
            return true;
        else
            return false;
    }
    @Override
    public String toString() {
        return title;
    }
    //---------------------------------------------------------

    //setters
    public boolean setProjectManager(ProjectManager projectManager) {
        if (projectManager.getProjects().size() == 0){
            projectManager.setProject(this);
            this.projectManager = projectManager;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean setTeamLeader(TeamLeader teamLeader) {
        if (teamLeader.getProject() == null) {
            this.teamLeader = teamLeader;
            teamLeader.setProject(this);
            status = States.INWORK;
            return true;
        }
        else
            return false;
    }
    public boolean setManager(Manager manager) {
        if (status == States.INWORK && manager.getProject() ==null){
            this.managers.add(manager);
            manager.setProject(this);
            return true;
        }
        else
            return false;
    }
    public boolean setEngineer(Engineer engineer) {
        if (status == States.INWORK && engineer.getProject() == null){
            this.engineers.add(engineer);
            engineer.setProject(this);
            return true;
        }
        else
            return false;
    }
    //---------------------------------------------------------

    //getters
    public ProjectManager getProjectManager() {
        return projectManager;
    }
    public ArrayList<Manager> getManagers() {
        return managers;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public double getBudget() {
        return budget;
    }
    public SeniorManager getSeniorManager() {
        return seniorManager;
    }
    public TeamLeader getTeamLeader() {
        return teamLeader;
    }
    public ArrayList<Engineer> getEngineers() {
        return engineers;
    }
}
