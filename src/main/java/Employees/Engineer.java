package Employees;

import com.fasterxml.jackson.annotation.JsonIgnore;

public  class Engineer extends Employee implements WorkTime, ProjectPayment {
    private long salaryForHour;
    public  Engineer(String name,String surname, long salaryForHour)
    {
        super(name,surname);
        this.salaryForHour=salaryForHour;
    }
    public  Engineer(long id,String name,String surname, long salaryForHour)
    {
        super(id,name,surname);
        this.salaryForHour=salaryForHour;
    }
    @JsonIgnore
    public long getSalaryForParticipation() {
        if(project==null)
            return 0;
        return project.getEmployeeParticipationPoints(this)*project.getParticipationPointSalary();
    }
    @JsonIgnore
    public long getSalaryForWorkTime() {
        return salaryForHour*workTime;
    }
    @JsonIgnore
    public long getSalary()
    {
        return  getSalaryForParticipation()+salaryForHour*workTime;
    }

    public long getSalaryForHour() {
        return salaryForHour;
    }

}
