package StaffDemo;

public class Tester extends Enginer {
    private Project project;
    private double partOfProject;

    public Tester(String surname, String name, String secondname, double partOfProject) {
        super(surname, name, secondname);
        this.partOfProject = partOfProject;
    }

    void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentWorkTime();
    }

    public double calcPaymentForPartOfProject() {
        return  partOfProject * project.budget;
    }

    public double calcPaymentWorkTime() {
        return rate * workTime;
    }
}
