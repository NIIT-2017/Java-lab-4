import java.util.ArrayList;

public class SeniorManager extends ProjectManager{
//fields
    ArrayList<Project> projects;
//constructor
    public SeniorManager (int id, String name, double projectPart){
        super (id, name, projectPart);
        this.projects = new ArrayList<>();
    }
//getters
    public ArrayList<Project> getProjects(){ return this.projects; }
//setters
    public void setProjects (ArrayList<Project> projects){ this.projects = projects; }
//methods
    @Override
    public double getPaymentByProject() {
        double result = 0;
        for (Project project : this.projects) {
            result += project.getProjectCost() * this.projectPart;
        }
        return result;
    }
}
