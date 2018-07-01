abstract class Personal extends Employee implements WorkTIme{
    private double paymentForHour;
    private double bonus;

    Personal(int id, String name, double worktime, double paymentForHour, double bonus) {
        super(id, name, worktime);
        this.paymentForHour = paymentForHour;
        this.bonus = bonus;
    }

    public double calcPaymentByWorkTime() {
        return getWorktime() * paymentForHour;
    }

    double getBonus() {
        return bonus;
    }
}
