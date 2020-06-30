public class ProjectManager extends Employee implements Heading {
    private String project;
    private Integer count;

    public ProjectManager(int id, String name, String project, Integer count){
        this.id = id;
        this.name = name;
        this.project = project;
        this.count = count;
    }

    @Override
    public Double result(Integer count) {
        return count * 1200.0;
    }

    @Override
    public void calc() {
        this.payment = result(count) + Project.projects.get(project) * 0.09;
    }
}
