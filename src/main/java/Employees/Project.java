package Employees;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ThreadLocalRandom;

public class Project {
    private String title;
    private ProjectManager projectManager;
    private ArrayList<Employee> employees;
    private HashMap<Long,Long> hashMapParticipationPoints;
    private long budget,participationPoints,participationPointSalary;
    public  Project(String title,ProjectManager projectManager,long budget,long participationPoints)
    {
        this.title=title;
        this.projectManager=projectManager;
        this.budget=budget;
        this.participationPoints=participationPoints;
        participationPointSalary=budget/participationPoints;
        employees=new ArrayList<>();
        hashMapParticipationPoints=new HashMap<>();
    }
    public  void addEmployee(Employee employee)
    {
        employees.add(employee);
    }

    public String getTitle() {
        return title;
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setParticipationPoints(long participationPoints) {
        this.participationPoints = participationPoints;
    }

    public long getParticipationPoints() {
        return participationPoints;
    }

    public long getBudget() {
        return budget;
    }
    @JsonIgnore
    public long getParticipationPointSalary(){return  participationPointSalary;}
    @JsonIgnore
    public long getEmployeeParticipationPoints(Employee employee)
    {
      return hashMapParticipationPoints.get(employee.getId());
    }
    public  void generateEmployeesPartitionPoints()
    {
        long leftPoints=participationPoints;
        for(int i=0;i<employees.size()-1;i++)
        {
            long maxLeftPointsForEmployee=(leftPoints/(employees.size()-i))*3;
            int employeePoints=ThreadLocalRandom.current().nextInt(0,(int)maxLeftPointsForEmployee);
            hashMapParticipationPoints.put(employees.get(i).getId(),(long)employeePoints);
            leftPoints=participationPoints-employeePoints;
        }
        hashMapParticipationPoints.put(employees.get(employees.size()-1).getId(),leftPoints);
    }
    public  HashMap getHashMapParticipationPoints()
    {
        return  hashMapParticipationPoints;
    }
    public Employee getEmployeeById(long id)
    {
        for (Employee employee: employees)
        {
            if(employee.getId()==id)
                return employee;
        }
        return null;
    }
    public void addParticipationPoint(long id,long points)
    {
        if(hashMapParticipationPoints==null)
            hashMapParticipationPoints=new HashMap<>();
        hashMapParticipationPoints.put(id,points);
    }
    public Employee getEmployeeByArrayIndex(int index)
    {
        return employees.get(index);
    }
}
