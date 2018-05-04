package StaffDemo;

import java.util.ArrayList;

public class Driver extends Personal {

    private double nightWorkHours;
    private double rateNightHours;

    public Driver(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public Driver(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }

    public void setNightWorkHours(double nightWorkHours) {
        this.nightWorkHours = nightWorkHours;
    }

    public void setRateNightHours(double rateNightHours) {
        this.rateNightHours = rateNightHours;
    }

    public double calcPaymentWorkTime() {
        return rateDayHours * dayWorkHours + rateNightHours * nightWorkHours;
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
