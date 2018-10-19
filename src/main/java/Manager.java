import java.util.ArrayList;

class Manager extends Employee implements  Project {
    protected String project;
    protected double projectBase;
    protected int projectPercent;

    Manager(int id, String fio, int workTime, String position, String project, double projectBase, int projectPercent){
        this.id = id;
        this.fio = fio;
        this.workTime = workTime;
        this.position = position;
        this.project = project;
        this.projectBase = projectBase;
        this.projectPercent = projectPercent;
    }

    protected void calculatePayment() {
        payment = projectPayment();
    }

    public double projectPayment() {
        return projectBase * projectPercent / 100;
    }

    public String getProject() {
        return project;
    }
}

class ProjectManager extends Manager implements Heading{
    protected int subordinates;

    ProjectManager(int id, String fio, int workTime, String position, String project,
               double projectBase, int projectPercent, int subordinates) {
        super(id, fio, workTime, position, project, projectBase, projectPercent);
        this.subordinates = subordinates;
    }
    @Override
    protected void calculatePayment(){
        payment = projectPayment() + headingPayment();
    }

    public double headingPayment() {
        return subordinates * subordinateBase;
    }
}

class SeniorManager extends ProjectManager{

    SeniorManager(int id, String fio, int workTime, String position, String project,
                  double projectBase, int projectPercent, int subordinates){
        super(id, fio, workTime, position, project, projectBase, projectPercent, subordinates);
    }
}
