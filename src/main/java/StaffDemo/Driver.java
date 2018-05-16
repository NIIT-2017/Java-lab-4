package StaffDemo;

import java.util.ArrayList;
//рассчет ЗП обычное время и ночные часы
public class Driver extends Personal {
    private double overTimeHours;
    private double rateOverTimeHour;
//конструктор для сооздания нового водителя
    public Driver(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }
//конструктор для чтения из файла
    Driver(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }
//расчет ЗП
    public void calcPayment() {
        payment = calcPaymentWorkTime() + calcPaymentOverTIme();
    }
//расчет сверхурочных часов
    public double calcPaymentOverTIme(){return  rateOverTimeHour * overTimeHours;}

    //установить сверхурочные часы

    public void setRateOverTimeHour(double rateOverTimeHour) {
        if(rateOverTimeHour>0)
            this.rateOverTimeHour = rateOverTimeHour;
    }
    //установить ставку за сверхурочные
    public void setOverTimeHours(double overTimeHours) {
        if (overTimeHours>0)
            this.overTimeHours = overTimeHours;
    }

    public double getOverTimeHours() {
        return overTimeHours;
    }

    public double getRateOverTimeHour() {
        return rateOverTimeHour;
    }

    //выбрать всех водителей из списка
    public static ArrayList<Driver> getDrivers(ArrayList<Employee> employees) {
        ArrayList<Driver> newArray = new ArrayList<Driver>();
        for(Employee next: employees){
            if (next.getClass().getSimpleName().equals("Driver")) {
                newArray.add((Driver) next);
            }
        }
        return newArray;
    }
}
