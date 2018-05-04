package StaffDemo;

import java.util.ArrayList;
public class Programmer extends Enginer {
    private double rateOvertimeHour;
    private double overtimeHours;

    public Programmer(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }

    public Programmer(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentWorkTime() + calcPaymentOvertime();
    }

    double calcPaymentOvertime() {
        return overtimeHours * rateOvertimeHour;
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

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setRateOvertimeHour(double rateOvertimeHour) {
        this.rateOvertimeHour = rateOvertimeHour;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
}
