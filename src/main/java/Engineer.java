public abstract class Engineer extends Employee implements WorkTime, Project
{
    private double base;
    public void setBase(double base) {
        this.base = base;
    }
    public double calcSalaryWorkTime() {
        return getWorkTime() * base;
    }
    public double calcSalaryProject() {
        return getWorkTime() * HR.getProjectRate(getProject());
    }
    public double calcSalaryWorkTimeProject() {
        return calcSalaryWorkTime() + calcSalaryProject();
    }
}
