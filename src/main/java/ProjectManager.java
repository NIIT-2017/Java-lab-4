public class ProjectManager extends Manager implements Heading
{
    private final double rate = 5000;
    public double getRate() {
        return rate;
    }
    public double calcSalaryHeading() {
        return rate * HR.getEmployeesCountOfProjectByTitle(getProject());
    }
    @Override
    public void calcSalary() {
        setSalary(calcSalaryProject() + calcSalaryHeading());
    }
}
