package StaffDemo;

public class Cleaner extends Personal {

    public Cleaner(String surname, String name, String secondname, double rate) {
        super(surname, name, secondname);
        this.ratePerDayHours = rate;
    }

    void calcPayment() {
        payment = calcPaymentWorkTime();
    }

    public double calcPaymentWorkTime() {
        return ratePerDayHours * dayWorkHours;
        }
}
