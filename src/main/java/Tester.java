public class Tester extends Engineer {
    private String project;

    public Tester(int id, String name, int worktime, double base, String project){
        this.id = id;
        this.name = name;
        this.worktime = worktime;
        this.base = base;
        this.project = project;
    }

    @Override
    public void calc() {
        this.payment = result(worktime, base) + Project.projects.get(project)*0.01;
    }
}
