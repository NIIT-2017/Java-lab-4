public abstract class Engineer extends Employee implements WorkTime, Project {
    protected double base;
    protected double share;
    protected String project;

    Engineer(int id, String name, String position, double base, double share, String project) {
        super(id, name, position);
        this.base = base;
        this.share = share;
        this.project = project;
    }

    public void setBase(double base) {this.base = base;}
    public void setShare(double share) {this.share = share;};
    public void setProject(String project) {this.project = project;};

    public double getBase() {return base;}
    public double getShare() {return share;}
    public String getProject() {return project;}
}
