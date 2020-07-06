package Employees;

public class Programmer extends  Engineer {
    public Programmer(String name,String surname, long salaryForHour)
    {
        super(name,surname,salaryForHour);
    }
    public Programmer(long id,String name,String surname, long salaryForHour)
    {
        super(id,name,surname,salaryForHour);
    }
}
