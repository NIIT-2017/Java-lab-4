
public abstract class Engineer extends Employee implements WorkTime, Project{

    protected int base;
    protected int percent;
    protected PROJECTS project;

    Engineer(int id, String name, String position, int base, int percent, PROJECTS project) {
        super(id, name, position);
        this.base = base;
        this.percent = percent;
        this.project = project;
    }
}

class Programmer extends Engineer {
    Programmer(int id, String name, String position, int base, int percent, PROJECTS project) {
        super(id, name, position, base, percent, project);
    }

    public int project (int percent, int budget){
        int projectPay = budget*percent/100;
        return projectPay;
    }

    public int workTime(int time, int base) {
        int payment = time * base;
        return payment;
    }
    @Override
    public void totalPayment(){
        this.payment += this.project(this.percent, this.project.projectBudget);
        this.payment += this.workTime(this.time, this.base);
    }
}

class Tester extends Engineer {
    Tester(int id, String name, String position, int base, int percent, PROJECTS project) {
        super(id, name, position, base, percent, project);
    }

    public int project (int percent, int budget){
        int projectPay = budget*percent/100;
        return projectPay;
    }

    public int workTime(int time, int base) {
        int payment = time * base;
        return payment;
    }
    @Override
    public void totalPayment(){
        this.payment += this.project(this.percent, this.project.projectBudget);
        this.payment += this.workTime(this.time, this.base);
    }
}

class TeamLeader extends Engineer implements Heading{
    protected int people;

    TeamLeader(int id, String name, String position, int base, int percent, PROJECTS project, int people) {
        super(id, name, position, base, percent, project);
        this.people = people;
    }

    public int project (int percent, int budget){
        int projectPay = budget*percent/100;
        return projectPay;
    }

    public int workTime(int time, int base) {
        int payment = time * base;
        return payment;
    }

    public int heading(int people){
        int headingPay = this.people * 1000;
        return headingPay;
    }
    @Override
    public void totalPayment(){
        this.payment += this.project(this.percent, this.project.projectBudget);
        this.payment += this.workTime(this.time, this.base);
        this.payment += this.heading(this.people);
    }
}