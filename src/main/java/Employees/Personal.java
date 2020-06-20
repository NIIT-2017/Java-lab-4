package Employees;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Personal extends Employee implements  WorkTime{
    protected  long salaryForHour;
    @JsonIgnore
    public   long getSalaryForWorkTime() {
        return workTime*salaryForHour;
    }
    public Personal(String name,String surname,long salaryForHour)
    {
        super(name,surname);
        this.salaryForHour=salaryForHour;
    }

    public void setSalaryForHour(long salaryForHour) {
        this.salaryForHour = salaryForHour;
    }

    public long getSalaryForHour() {
        return salaryForHour;
    }

    public Personal(long id, String name, String surname, long salaryForHour)
    {
        super(id,name,surname);
        this.salaryForHour=salaryForHour;
    }
    public  long getSalary()
    {
        return  getSalaryForWorkTime();
    }
}
