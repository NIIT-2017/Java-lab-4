public class SeniorManager extends ProjectManager
{
    @Override
    public double calcSalaryProject() {
        return getWorkTime() * HR.getSeniorRate();
    }
    @Override
    public double calcSalaryHeading() {
        return getRate() * HR.getEmployeesCountOfAllProjects();
    }
    @Override
    public void calcSalary() {
        setSalary(calcSalaryProject() + calcSalaryHeading());
    }
}
