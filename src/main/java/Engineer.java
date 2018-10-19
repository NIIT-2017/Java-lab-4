abstract class Engineer extends Employee implements WorkTime, Project {
    protected double base;
    protected String project;
    protected double projectBase;
    protected int projectPercent;

    Engineer(int id, String fio, int workTime, String position, double base, String project,
             double projectBase, int projectPercent){
        this.id = id;
        this.fio = fio;
        this.workTime = workTime;
        this.position = position;
        this.base = base;
        this.project = project;
        this.projectBase = projectBase;
        this.projectPercent = projectPercent;
    }

    protected void calculatePayment() {
        payment = workTimePayment() + projectPayment();
    }

    public double projectPayment() {
        return projectBase * projectPercent / 100;
    }

    public double workTimePayment() {
        return base * workTime;
    }

    public String getProject() {
        return project;
    }
}

class Programmer extends Engineer{
    Programmer(int id, String fio, int workTime, String position, double base, String project,
               double projectBase, int projectPercent){
        super(id, fio, workTime, position, base, project, projectBase, projectPercent);
    }
    @Override
    protected void calculatePayment() {
        payment = workTimePayment() * 1.1 + projectPayment();
    }
}

class Tester extends Engineer{
    Tester(int id, String fio, int workTime, String position, double base, String project,
           double projectBase, int projectPercent){
        super(id, fio, workTime, position, base, project, projectBase, projectPercent);
    }
}

class TeamLeader extends Programmer implements Heading{
    private int subordinates;
    TeamLeader(int id, String fio, int workTime, String position, double base, String project,
               double projectBase, int projectPercent, int subordinates){
        super(id, fio, workTime, position, base, project, projectBase, projectPercent);
        this.subordinates = subordinates;
    }

    @Override
    protected void calculatePayment() {
        payment = workTimePayment() + projectPayment() + headingPayment();
    }

    public double headingPayment() {
        return subordinates * subordinateBase;
    }
}
