package StaffDemo;

public class Manager extends Employee implements PaymentForProject {
    protected Project project;
    protected double rate;

    public Manager(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    void calcPayment() {
        payment = calcPaymentForPartOfProject();
    }

    public double calcPaymentForPartOfProject() {
        if (this.project==null) return 0.0;
        else return rate*this.project.budget;
    }
}
