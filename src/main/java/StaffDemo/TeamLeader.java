package StaffDemo;

import java.util.ArrayList;
//руководитель группы
public class TeamLeader extends Programmer implements Heading{
    private double ratePerEmployees;
//конструктор для нового
    public TeamLeader(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }
//конструктор для чтения из файла
    TeamLeader(String id, String surname, String name, String secondname) {
        super(id, surname, name, secondname);
    }
//расчет ЗП за участие в проекте + заотработарнное время + сверхурочное время + руководство
    public void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentWorkTime() + calcPaymentForHeading() + calcPaymentOvertime();
    }
//расчет за руководство
    public double calcPaymentForHeading() {
        int countProgrammers = Programmer.getProgrammers(getProject().getEmployee()).size();
        return ratePerEmployees * countProgrammers;
    }
//сетеры и гетеры
    public void setRatePerEmployees(double ratePerEmploues) {
        if (ratePerEmploues > 0) {
            this.ratePerEmployees = ratePerEmploues;
        }
    }

    public double getRatePerEmployees() {
        return ratePerEmployees;
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
