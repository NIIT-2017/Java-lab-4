class Driver extends Personal{
    public Driver(int id, String name, double workTime, double payForHour, double bonus) {
        super(id, name, workTime, payForHour, bonus);
    }

    @Override
    double calcPayment() {
        double payment = calcPaymentByWorkTime() + getBonus();
        setPayment(payment);
        return payment;
    }
}
