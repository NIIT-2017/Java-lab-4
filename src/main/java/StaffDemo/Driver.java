package StaffDemo;

import java.util.ArrayList;

public class Driver extends Personal {
    private double overTimeHours;
    private double rateOverTimeHour;

    public Driver(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public Driver(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }

    public void calcPayment() {
        payment = calcPaymentWorkTime();
    }

    public double calcPaymentWorkTime() {
        return ratePerWorkHour * workHours + rateOverTimeHour * overTimeHours;
    }

    public void setRateOverTimeHour(double rateOverTimeHour) {
        this.rateOverTimeHour = rateOverTimeHour;
    }

    public void setOverTimeHours(double overTimeHours) {
        this.overTimeHours = overTimeHours;
    }

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
