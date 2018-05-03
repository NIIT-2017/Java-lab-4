package StaffDemo;

import java.util.ArrayList;

public class Driver extends Personal {

    private double nightWorkHours;
    private double ratePerNightHours;

    public Driver(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public Driver(String id, String surname, String name, String secondname) {
        super(id, surname, name, secondname);
    }

    public void setNightWorkHours(double nightWorkHours) {
        this.nightWorkHours = nightWorkHours;
    }

    public void setRatePerNightHours(double ratePerNightHours) {
        this.ratePerNightHours = ratePerNightHours;
    }

    public double calcPaymentWorkTime() {
        return ratePerDayHours * dayWorkHours + ratePerNightHours * nightWorkHours;
    }

    public void calcPayment() {
        payment = calcPaymentWorkTime();
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
