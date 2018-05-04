package StaffDemo;

import java.util.ArrayList;
import java.util.List;

public class SeniorManager extends ProjectManager {
    private ArrayList<Project> projects;

    public SeniorManager(String surname, String name, String secondname) {
        super(surname, name, secondname);
        projects = new ArrayList<Project>();
    }

    public SeniorManager(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }

    public void calcPayment() {
        payment = calcPaymentForHeading();
    }

    public double calcPaymentForHeading() {
        double summ = 0.0;
        for (Project nextProject : projects) {
            summ += getRate() * (nextProject.getEmployee().size()+2);
        }
        return summ;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public static ArrayList<SeniorManager> getSeniorManagers(ArrayList<Employee> employees) {
        ArrayList<SeniorManager> newArray = new ArrayList<SeniorManager>();
        for(Employee next: employees){
            if (next.getClass().getSimpleName().equals("SeniorManager")) {
                newArray.add((SeniorManager) next);
            }
        }
        return newArray;
    }

    void addProject(Project project) {
        projects.add(project);
    }

    void addProjects(List<Project> project) {
        projects.addAll(project);
    }
}
