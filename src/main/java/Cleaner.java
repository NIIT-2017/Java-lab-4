public class Cleaner extends Personal
{
    private final double cleanerBase = 200;
    public void calcSalary() {
        setBase(cleanerBase);
        setSalary(calcSalaryWorkTime());
    }
}
