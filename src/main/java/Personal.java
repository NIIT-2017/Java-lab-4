public abstract class Personal extends Employee implements WorkTime
{
    private double base;
    public void setBase(double base) {
        this.base = base;
    }
    public double calcSalaryWorkTime() {
        return getWorkTime() * base;
    }
}
