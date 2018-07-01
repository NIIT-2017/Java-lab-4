class Cleaner extends Personal{
    Cleaner(int id, String name, double worktime, double payForHour, double bonus) {
        super(id, name, worktime, payForHour, bonus);
    }

    @Override
    double calcPayment(){
        double payment = calcPaymentByWorkTime() + getBonus();
        setPayment(payment);
        return payment;
    }
}
