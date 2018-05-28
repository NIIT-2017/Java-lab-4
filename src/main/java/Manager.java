public class Manager extends Employee implements Project
{
    public double calcSalaryProject() {
        return getWorkTime() * HR.getProjectRate(getProject());
    }
    public void calcSalary() {
        setSalary(calcSalaryProject());
    }
}
