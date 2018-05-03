package StaffDemo;

import java.util.ArrayList;

public class TeamLeader extends Programmer implements Heading{
    private ArrayList<Programmer> programmers;
    private Project project;
    private double rateForProgrammer;

    public TeamLeader(String surname, String name, String secondname) {
        super(surname, name, secondname);
        programmers = new ArrayList<Programmer>();
    }

    public TeamLeader(String id, String surname, String name, String secondname) {
        super(id, surname, name, secondname);
    }

    public void setProject(Project project) {
        this.project = project;
    }

    void addWorker(Programmer programmer) {
        programmers.add(programmer);
    }

    public void setRateForProgrammer(double rateForProgrammer) {
        this.rateForProgrammer = rateForProgrammer;
    }

    public void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentWorkTime() + calcPaymentForHeading();
    }

    public double calcPaymentForHeading() {
        return rateForProgrammer*programmers.size();
    }


}
