package StaffDemo;

public class Driver extends Personal {

    private double nightWorkHours;
    private double ratePerNightHours;

    public Driver(String surname, String name, String secondname, double ratePerDayHours, double ratePerNightHours) {
        super(surname, name, secondname);
        this.ratePerNightHours = ratePerNightHours;
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

    void calcPayment() {
        payment = calcPaymentWorkTime();
    }
}
