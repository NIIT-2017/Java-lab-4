package StaffDemo;

import java.util.ArrayList;

public class Manager extends Employee implements PaymentForProject {
    private Project project;
    private double rate;

    public Manager(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public Manager(String id, String surname, String name, String secondname) {
        super(id, surname, name, secondname);
    }

    public void calcPayment() {
        payment = calcPaymentForPartOfProject();
    }

    public double calcPaymentForPartOfProject() {
        if (this.project==null) return 0.0;
        else return rate*this.project.getBudget();
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    Project getProject() {
        return project;
    }

    double getRate() {
        return rate;
    }

    public static ArrayList<Manager> getManagers(ArrayList<Employee> employees) {
        ArrayList<Manager> newArray = new ArrayList<Manager>();
        for(Employee next: employees){
            if (next.getClass().getSimpleName().equals("Manager")) {
                newArray.add((Manager) next);
            }
        }
        return newArray;
    }
}
