package StaffDemo;

public class Tester extends Enginer {
    private Project project;
    private double partOfProject;

    public Tester(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public void setPartOfProject(double partOfProject) {
        this.partOfProject = partOfProject;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentWorkTime();
    }

    public double calcPaymentForPartOfProject() {
        return  project.allotMoney(partOfProject * project.budget);
    }

    public double calcPaymentWorkTime() {
        return rate * workTime;
    }
}
