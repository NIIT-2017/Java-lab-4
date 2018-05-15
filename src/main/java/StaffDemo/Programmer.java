package StaffDemo;

import java.util.ArrayList;
public class Programmer extends Enginer {
//программист может работать сверхурочно
    private double rateOvertimeHour;
    private double overtimeHours;
//конструктор для создания нового
    Programmer(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }
//конструктор для чтения из файла
    public Programmer(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }
//расчет ЗП как от участия в проекте + отработтанное время + оплата сверхурочных
    public void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentWorkTime() + calcPaymentOvertime();
    }
//расчет сверхурочных
    double calcPaymentOvertime() {
        return overtimeHours * rateOvertimeHour;
    }
//сетеры и гетеры
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
