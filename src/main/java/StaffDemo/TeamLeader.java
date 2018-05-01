package StaffDemo;

import java.util.ArrayList;

public class TeamLeader extends Programmer implements Heading{
    private ArrayList<Programmer> programmers;
    private double rateForProgrammer;

    public TeamLeader(String surname, String name, String secondname, double rateForProgrammer) {
        super(surname, name, secondname);
        programmers = new ArrayList<Programmer>();
        this.rateForProgrammer = rateForProgrammer;
    }

    void addWorker(Programmer programmer) {
        programmers.add(programmer);
    }

    void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentWorkTime() + calcPaymentForHeading();
    }

    public double calcPaymentForHeading() {
        return rateForProgrammer*programmers.size();
    }
}
