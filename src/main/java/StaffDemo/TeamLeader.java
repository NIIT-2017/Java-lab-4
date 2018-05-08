package StaffDemo;

import java.util.ArrayList;

public class TeamLeader extends Programmer implements Heading{
    private double ratePerEmployees;

    public TeamLeader(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public TeamLeader(String id, String surname, String name, String secondname) {
        super(id, surname, name, secondname);
    }

    public void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentWorkTime() + calcPaymentForHeading() + calcPaymentOvertime();
    }

    public double calcPaymentForHeading() {
        int countProgrammers = Programmer.getProgrammers(getProject().getEmployee()).size();
        return ratePerEmployees * countProgrammers;
    }

    public void setRatePerEmployees(double ratePerEmploues) {
        this.ratePerEmployees = ratePerEmploues;
    }

    public static ArrayList<TeamLeader> getTeamLeaders(ArrayList<Employee> employees) {
        ArrayList<TeamLeader> newArray = new ArrayList<TeamLeader>();
        for(Employee next: employees){
            if (next.getClass().getSimpleName().equals("TeamLeader")) {
                newArray.add((TeamLeader) next);
            }
        }
        return newArray;
    }
}
