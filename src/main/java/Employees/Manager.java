package Employees;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Manager extends Employee implements ProjectPayment {
    protected ArrayList<Employee> subordinates;
    public  Manager(String name,String surname)
    {
        super(name,surname);
        subordinates=new ArrayList<>();
    }
    public  Manager(long id,String name,String surname)
    {
        super(id,name,surname);
        subordinates=new ArrayList<>();
    }
    public long getSalary() {
        return getSalaryForParticipation();
    }

    @JsonIgnore
    public long getSalaryForParticipation()
    {
        if(project==null)
            return -1;
        else {
            long participationPoints=project.getEmployeeParticipationPoints(this);
            long participationPointSalary=project.getParticipationPointSalary();
            return  participationPoints*participationPointSalary ;
        }
    }
    public  void addSubordinate(Employee employee)
    {
        if(subordinates==null)
            subordinates=new ArrayList<>();
        subordinates.add(employee);
    }
    public void removeEmployee(Employee employee)
    {
        if(employee.getManager()==this)
            employee.setManager(null);
        subordinates.remove(employee);
    }
    public Employee getSubordinateById(long id)
    {
        for(Employee employee : subordinates)
        {
            if (employee.getId() == id)
                return employee;
        }
        return null;
    }
}
