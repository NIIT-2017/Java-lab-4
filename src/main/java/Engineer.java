public abstract class Engineer extends Employee implements WorkTime {

    public abstract void calc();

    @Override
    public double result(int worktime, double base) {
        return worktime * base;
    }
}
