package Employees;

public class SeniorManager extends  ProjectManager{
    public  SeniorManager(String name,String surname,long salaryForSubordinate)
    {
        super(name, surname,salaryForSubordinate);
    }
    public  SeniorManager(long id,String name,String surname,long salaryForSubordinate)
    {
        super(id,name, surname,salaryForSubordinate);
    }
}