package Employees;

public class Driver extends  Personal {
    public Driver(String name,String surname,long salaryForHour)
    {
        super(name,surname,salaryForHour);
    }
    public Driver(long id,String name,String surname,long salaryForHour)
    {
        super(id,name,surname,salaryForHour);
    }
}
