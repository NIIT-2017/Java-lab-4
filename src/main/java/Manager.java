public class Manager extends Employee {
    protected String project;

    public Manager(int id, String name, String project){
        this.id = id;
        this.name = name;
        this.project = project;
    }

    @Override
    public void calc() {
        this.payment = Project.projects.get(project) * 0.03;
    }
}
