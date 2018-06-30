public class Driver extends Personal{
    public Driver(int id, String name, double workTime, double payment, double baseRate) {
        super(id, name, workTime, payment, baseRate);
    }

    @Override
    public double calcPayment() {
        return paymentFromTime();
    }

    public double paymentFromTime() {
        if (workTime > 160)                 //в случае переработки
            return baseRate * workTime * 1.2;
        else return baseRate * workTime;
    }
}
