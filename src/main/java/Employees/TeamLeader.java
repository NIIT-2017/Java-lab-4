package Employees;

import java.util.ArrayList;

public class TeamLeader extends  Programmer implements  Heading{
    private ArrayList<Employee> subordinates;
    private long salaryPerSubordinate;
    public TeamLeader(String name,String surname, int salaryForHour,long salaryForSubordinate)
    {
        super(name,surname,salaryForHour);
        this.salaryPerSubordinate=salaryForSubordinate;
    }
    public TeamLeader(long id,String name,String surname, int salaryForHour,long salaryForSubordinate)
    {
        super(id,name,surname,salaryForHour);
        this.salaryPerSubordinate=salaryForSubordinate;
    }
    public long getSalaryForHeading() {
        return salaryPerSubordinate*subordinates.size();
    }

    @Override
    public long getSalaryPerSubordinate() {
        return salaryPerSubordinate;
    }

    @Override
    public void setSalaryPerSubordinate(long salaryPerSubordinate) {
        this.salaryPerSubordinate=salaryPerSubordinate;
    }

    public long getSalary()
    {
       return super.getSalary()+getSalaryForHeading();
    }
}
