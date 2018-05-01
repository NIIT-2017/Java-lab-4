package StaffDemo;

import java.util.ArrayList;

public class SeniorManager extends ProjectManager {
    private ArrayList<Project> projects;

    public SeniorManager(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    void addProject(Project project) {
        projects.add(project);
    }

    void calcPayment() {
        payment = calcPaymentForHeading();
    }

    public double calcPaymentForHeading() {
        double summ = 0.0;
        for (Project nextProject : projects) {
            summ += rate * nextProject.workers.size();
        }
        return summ;
    }
}
