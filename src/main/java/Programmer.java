public class Programmer extends Engineer
{
    private final double programmerBase = 240;
    public double getProgrammerBase() {
        return programmerBase;
    }
    public void calcSalary() {
        setBase(programmerBase);
        setSalary(calcSalaryWorkTimeProject());
    }
}
