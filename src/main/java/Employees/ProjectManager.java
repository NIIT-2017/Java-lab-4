package Employees;

public class ProjectManager extends  Manager implements Heading{
    private long salaryPerSubordinate;
    public  ProjectManager(String name,String surname,long salaryForSubordinate)
    {
        super(name, surname);
        this.salaryPerSubordinate=salaryForSubordinate;
    }
    public  ProjectManager(long id,String name,String surname,long salaryForSubordinate)
    {
        super(id,name, surname);
        this.salaryPerSubordinate=salaryForSubordinate;
    }
    public long getSalaryForHeading() {
        return salaryPerSubordinate*subordinates.size();
    }
    public long getSalaryPerSubordinate()
    {
        return salaryPerSubordinate;
    }

    @Override
    public void setSalaryPerSubordinate(long salaryPerSubordinate) {
        this.salaryPerSubordinate=salaryPerSubordinate;
    }

    public long getSalary()
    {
        long salaryForHeading=getSalaryForHeading();
        long salaryForParticipation=getSalaryForParticipation();
      return salaryForHeading+salaryForParticipation;
    }
}
