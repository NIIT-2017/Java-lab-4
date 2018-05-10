package StaffDemo;

import java.util.ArrayList;
import java.util.List;

public class SeniorManager extends Employee {
    private ArrayList<Project> projects;
    private double ratePerProject;

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

    private double calcPaymentForHeading() {
        return ratePerProject * projects.size();
    }

    public void setRatePerProject(double ratePerProject) {
        this.ratePerProject = ratePerProject;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public static SeniorManager getSeniorManager(ArrayList<Employee> employees) {
        for(Employee next: employees){
            if (next.getClass().getSimpleName().equals("SeniorManager")) {
                return (SeniorManager) next;
            }
        }
        return null;
    }
}
