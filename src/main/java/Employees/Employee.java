package Employees;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "class")
public abstract class Employee {
    protected static int maxId=0;
    protected long id;
    public long getId() { return id; }
    protected String name,surname;
    protected long workTime;
    protected Manager manager;
    protected Project project;
    public  String getName(){return name;}
    public  String getSurname(){return surname;}
    @JsonIgnore
    public Manager getManager(){return  manager;}
    public  long getManagerId()
    {
        if(manager!=null)
            return  manager.id;
        else
            return -1;
    }
    @JsonIgnore
    public String getProgectTitle()
    {
        if(project!=null)
            return project.getTitle();
        else
            return  "None";
    }
    @JsonIgnore
    public  Project getProject()
    {
        return  project;
    }
    public void setProject(Project project)
    {
        this.project=project;
        project.addEmployee(this);
    }
    protected Employee(String name,String surname)
    {
        id=maxId;
        maxId++;
        this.name=name;
        this.surname=surname;
    }
    protected Employee(long id,String name,String surname)
    {
        this.id=id;
        this.name=name;
        this.surname=surname;
    }
    @JsonIgnore
    public abstract long getSalary();

    public void setManager(Manager manager) {
        if(this.manager!=null)
            this.manager.removeEmployee(this);
        this.manager = manager;
        manager.addSubordinate(this);
    }

    public long getWorkTime() {
        return workTime;
    }
    public void setWorkTime(long workTime) {
        this.workTime = workTime;
    }
}
