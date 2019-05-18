public abstract class Personal extends Employee implements Worktime {
    protected int rate;
    public Personal(int id, String name, int rate) {
        super(id, name);
        this.rate=rate;
    }

    public int wtcalc(int rate, int worktime) {
        return rate * worktime;
    }
}
