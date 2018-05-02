package StaffDemo;

public class Driver extends Personal {

    private double nightWorkHours;
    private double ratePerNightHours;

    public Driver(String surname, String name, String secondname) {
        super(surname, name, secondname);
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
}
