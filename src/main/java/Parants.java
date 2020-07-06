import java.util.HashSet;
import java.util.Set;

abstract class Employee {
    protected int id;
    protected String name;
    protected int worktime;
    protected float payment;

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getWorktime() {
        return worktime;
    }
    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }
    //Calculate final payment
    abstract protected float calculatePayment();
    public float getPayment() {
        return payment = calculatePayment();
    }

    public String getInformation(){
        return "Name : " + name + ", worktime : " + worktime + " hours, payment : " + getPayment();
    }
}

abstract class Personal extends Employee implements WorkTime{
    protected int base;
    protected WorktimeJob worktimeJob = new WorktimeJob();

    public Personal(int id, String name, int base) {
        super(id, name);
        this.base = base;
    }

    @Override
    public int getBase() {
        return base;
    }
    @Override
    public float moneyForWorktime(){
        return worktimeJob.moneyForWorktime(base, worktime);
    }
    @Override
    protected float calculatePayment() {
        return moneyForWorktime();
    }
}

abstract class Engineer extends Employee implements WorkTime, Project{
    protected int base;
    protected WorktimeJob worktimeJob = new WorktimeJob();
    protected ProjectJob projectJob;

    public Engineer(int id, String name, int base) {
        super(id, name);
        this.base = base;
        projectJob = new ProjectJob();
    }
    public Engineer(int id, String name, int base, HashSet<String> projects){
        this(id, name, base);
        projectJob = new ProjectJob(projects);
    }

    @Override
    public int getBase() {
        return base;
    }

    @Override
    public Set<String> getProjects() {
        return projectJob.getProjects();
    }
    @Override
    public float moneyForWorktime(){
        return worktimeJob.moneyForWorktime(base, worktime);
    }
    @Override
    protected float calculatePayment() {
        return moneyForWorktime() + moneyForProjects();
    }
    @Override
    public float moneyForProjects() {
        return projectJob.moneyForProjects(id);
    }
    @Override
    public boolean setProject(String projectTitle) {
        return projectJob.setProject(id, projectTitle);
    }
}
