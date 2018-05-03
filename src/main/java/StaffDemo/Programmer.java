package StaffDemo;

import java.util.ArrayList;
public class Programmer extends Enginer {

    private Project project;
    private double partOfProject;

    public Programmer(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public Programmer(String id, String surname, String name, String secondname) {
        super(id, surname, name, secondname);
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setPartOfProject(double partOfProject) {
        this.partOfProject = partOfProject;
    }

    public void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentWorkTime();
    }

    public double calcPaymentForPartOfProject() {
        return project.allotMoney(partOfProject * project.getBudget());
    }

    public double calcPaymentWorkTime() {
        return workTime*rate;
    }

    public static ArrayList<Programmer> getProgrammers(ArrayList<Employee> employees) {
        ArrayList<Programmer> newArray = new ArrayList<Programmer>();
        for(Employee next: employees){
            if (next.getClass().getSimpleName().equals("Programmer")) {
                newArray.add((Programmer) next);
            }
        }
        return newArray;
    }

    class Work{

        Project project;
        double part;

        Work(Project project, double part) {
            this.project = project;
            this.part = part;
        }
    }
}
