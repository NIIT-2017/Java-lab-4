abstract public class Employee {
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public byte getId() {
        return id;
    }
    public void setId(byte id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPayment() {
        return payment;
    }
    public void setPayment(int payment) {
        this.payment = payment;
    }
    public short getWorktime() {
        return worktime;
    }
    public void setWorktime(short worktime) {
        this.worktime = worktime;
    }
    public short getBase() {
        return base;
    }
    public void setBase(short base) {
        this.base = base;
    }
    public byte getPercent() {
        return percent;
    }
    public void setPercent(byte percent) {
        this.percent = percent;
    }
    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }
    public byte getNumberEmployees() {
        return numberEmployees;
    }
    public void setNumberEmployees(byte numberEmployees) {
        this.numberEmployees = numberEmployees;
    }
    public byte getPercent_1() {
        return percent_1;
    }
    public void setPercent_1(byte percent_1) {
        this.percent_1 = percent_1;
    }
    public String getProject_1() {
        return project_1;
    }
    public void setProject_1(String project_1) {
        this.project_1 = project_1;
    }
    public byte getPercent_2() {
        return percent_2;
    }
    public void setPercent_2(byte percent_2) {
        this.percent_2 = percent_2;
    }
    public String getProject_2() {
        return project_2;
    }
    public void setProject_2(String project_2) {
        this.project_2 = project_2;
    }

    private byte percent;
    private String project;
    private byte percent_1;
    private String project_1;
    private byte percent_2;
    private String project_2;
    private byte numberEmployees;
    private short base;
    private String position;
    private byte id;
    private String name;
    private int payment;
    private short worktime;

    Employee(){
        Settings settings = new Settings();
        setWorktime(settings.getWorkTimeMonth());
    }
    abstract public void pay();
}

abstract class Personal extends Employee implements WorkTime{
    Personal(byte id, String name, short base){
        setId(id);
        setName(name);
        setBase(base);
        pay();
    }
    @Override
    public void pay(){
        setPayment(payWorktime(getBase(),getWorktime()));
    }
}

class Cleaner extends Personal {
    Cleaner(byte id, String name, short base){
        super(id, name, base);
        setPosition("Cleaner");
    }
}

class Driver extends Personal {
    Driver(byte id, String name, short base){
        super(id, name, base);
        setPosition("Driver");
    }
}


abstract class Engineer extends Personal implements Project{
    Engineer(byte id, String name, short base, byte percent, String project){
        super(id, name, base);
        setPercent(percent);
        setProject(project);
        pay();
    }
    public void pay(){
        setPayment(payWorktime(getBase(),getWorktime()) + payProject(getPercent(), getProject()));
    }
}

class Programmer extends Engineer{
    Programmer(byte id, String name, short base, byte percent, String project){
        super (id, name, base, percent, project);
        setPosition("Programmer");
    }
}

class Tester extends Engineer{
    Tester(byte id, String name, short base, byte percent, String project){
        super (id, name, base, percent, project);
        setPosition("Tester");
    }
}

class TeamLeader extends Engineer implements Heading {
    TeamLeader(byte id, String name, short base, byte percent, String project, byte numberEmployees) {
        super(id, name, base, percent, project);
        setPosition("TeamLeader");
        setNumberEmployees(numberEmployees);
        pay();
    }
    @Override
    public void pay() {
        setPayment(payWorktime(getBase(), getWorktime()) + payProject(getPercent(), getProject()) + payHeading(getNumberEmployees()));
    }
}

class Manager extends Employee implements Project{
     Manager(byte id, String name, byte percent, String project){
        setId(id);
        setName(name);
        setPercent(percent);
        setProject(project);
        setPosition("Manager");
        pay();
     }
     public void pay(){
         setPayment(payProject(getPercent(), getProject()));
     }
}

class ProjectManager extends Manager implements Heading {
    ProjectManager(byte id, String name, byte percent, String project, byte numberEmployees) {
        super(id, name, percent, project);
        setPosition("ProjectManager");
        setNumberEmployees(numberEmployees);
        pay();
    }

    @Override
    public void pay() {
        setPayment(payProject(getPercent(), getProject()) + payHeading(getNumberEmployees()));
    }

}

class SeniorManager extends ProjectManager {
    SeniorManager(byte id, String name, byte percent, String project, byte percent_1, String project_1, byte percent_2, String project_2, byte numberEmployees) {
        super(id, name, percent, project, numberEmployees);
        setPercent_1(percent_1);
        setPercent_2(percent_2);
        setProject_1(project_1);
        setProject_2(project_2);
        setPosition("SeniorManager");
        pay();
    }
    @Override
    public void pay() {
        setPayment(payProject(getPercent(), getProject()) + payProject(getPercent_1(), getProject_1()) + payProject(getPercent_2(), getProject_2()) + payHeading(getNumberEmployees()));
    }
}


