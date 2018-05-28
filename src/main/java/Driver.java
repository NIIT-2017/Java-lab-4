public class Driver extends Personal
{
    private final double driverBase = 210;
    private final double category = 1.20;
    public void calcSalary() {
        setBase(driverBase);
        setSalary(calcSalaryWorkTime() * category);
    }
}
