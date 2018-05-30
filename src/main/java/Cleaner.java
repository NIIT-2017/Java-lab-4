public class Cleaner extends Personal {
    Cleaner(int id, String name, String position, double base) {
        super(id, name, position, base);
    }

    public void calcPayment(){
        payment = calcPaymentFromTime();
    }

    public double calcPaymentFromTime() {
        return base * time;
    }
}
