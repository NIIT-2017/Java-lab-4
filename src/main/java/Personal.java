public abstract class Personal extends Employee implements WorkTime {
    protected double baseRate;      //базовая ставка руб./час

    public Personal(int id, String name, double workTime, double payment, double baseRate) {
        super(id, name, workTime, payment);
        this.baseRate = baseRate;
    }
}
