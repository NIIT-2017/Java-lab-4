public class Tester extends Engineer
{
    private final double testerBase = 220;
    public void calcSalary() {
        setBase(testerBase);
        setSalary(calcSalaryWorkTimeProject());
    }
}
