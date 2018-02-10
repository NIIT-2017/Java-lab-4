public class Manager extends Employee implements Project{
    protected int percent;
    protected PROJECTS project;

    Manager(int id, String name, String position, int percent, PROJECTS project){
        super(id, name, position);
        this.percent = percent;
        this.project = project;
    }

    public int project (int percent, int budget){
        int projectPay = budget*percent/100;
        return projectPay;
    }

    @Override
    public void totalPayment(){
        this.payment = this.project(this.percent, this.project.projectBudget);
    }
}

class ProjectManager extends Manager implements Heading{

    protected int people;

    ProjectManager(int id, String name, String position, int percent, PROJECTS project, int people){
        super(id, name, position, percent, project);
        this.people = people;
    }
    @Override
    public int project (int percent, int budget){
        int projectPay = budget*percent/100;
        return projectPay;
    }

    public int heading(int people){
        int headingPay = this.people * 2500;
        return headingPay;
    }
    @Override
    public void totalPayment(){
        this.payment += this.project(this.percent, this.project.projectBudget);
        this.payment += this.heading(this.people);

    }
}

class SeniorManager extends ProjectManager{

    SeniorManager(int id, String name, String position, int percent, PROJECTS project, int people){
        super(id, name, position, percent, project, people);
    }
    @Override
    public int project (int percent, int budget){
        int projectPay = budget*percent/100;
        return projectPay;
    }

    @Override
    public int heading(int people){
        int headingPay = this.people * 4000;
        return headingPay;
    }

    @Override
    public void totalPayment(){
        this.payment += this.project(this.percent, this.project.projectBudget);
        this.payment += this.heading(this.people);

    }

}
