public class TeamLeader extends Engineer implements Heading {
    private String project;
    private Integer count;

    public TeamLeader(int id, String name, int worktime, double base, String project, Integer count){
        this.id = id;
        this.name = name;
        this.worktime = worktime;
        this.base = base;
        this.project = project;
        this.count = count;
    }

    public void calc() {
        this.payment = super.result(worktime, base) + result(count) + Project.projects.get(project) * 0.03;
    }

    @Override
    public Double result(Integer count) {
        return count * 900.0;
    }
}
