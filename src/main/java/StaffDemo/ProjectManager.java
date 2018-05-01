package StaffDemo;

public class ProjectManager extends Manager implements Heading{
    public ProjectManager(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentForHeading();
    }

    public double calcPaymentForHeading() {
        return rate*project.workers.size();
    }
}
