package StaffDemo;

public class Cleaner extends Personal {

    public Cleaner(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public void calcPayment() {
        payment = calcPaymentWorkTime();
    }

    public double calcPaymentWorkTime() {
        return ratePerDayHours * dayWorkHours;
        }
}
