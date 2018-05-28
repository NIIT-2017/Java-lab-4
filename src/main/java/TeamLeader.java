public class TeamLeader extends Programmer implements Heading
{
    private final double teamLeaderRate = 3000;
    public double calcSalaryHeading() {
        return teamLeaderRate * HR.getProgrammersCountOfProject(getProject());
    }
    @Override
    public void calcSalary() {
        setBase(getProgrammerBase());
        setSalary(calcSalaryWorkTimeProject() + calcSalaryHeading());
    }
}
