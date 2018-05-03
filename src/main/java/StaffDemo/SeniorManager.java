package StaffDemo;

import java.util.ArrayList;

public class SeniorManager extends ProjectManager {
    private ArrayList<Project> projects;

    public SeniorManager(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public SeniorManager(String id, String surname, String name, String secondname) {
        super(id, surname, name, secondname);
    }

    void addProject(Project project) {
        projects.add(project);
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
}
