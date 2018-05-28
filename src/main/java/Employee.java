public abstract class Employee
{
    abstract public void calcSalary();
    private int id;
    private String fName;
    private String position;
    private double workTime;
    private String project;
    private double salary;
    public void setData(int id, String fName, String position, double workTime, String project) { //set employee's data
        this.id = id;
        this.fName = fName;
        this.position = position;
        this.workTime = workTime;
        this.project = project;
        this.salary = 0;
    }
    public void setSalary(double salary) { //set employee's salary
        this.salary = salary;
    }
    public int getId() { //get employee's id
        return id;
    }
    public String getFName() { //get employee's full name
        return fName;
    }
    public String getPosition() { //get employee's position
        return position;
    }
    public double getWorkTime() { //get employee's workTime
        return workTime;
    }
    public String getProject() { //get employee's project's name
        return project;
    }
    public double getSalary() { //get employee's salary
        return salary;
    }
}
