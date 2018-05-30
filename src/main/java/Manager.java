public class Manager extends Employee implements Project {
    protected double share;
    protected String project;

    Manager(int id, String name, String position, double share, String project) {
        super(id, name, position);
        this.share = share;
        this.project = project;
    }

    public void setShare(double share) {this.share = share;};
    public void setProject(String project) {this.project = project;};

    public double getShare() {return share;}
    public String getProject() {return project;}

    public double calcPaymentFromProject() {
        return share * DataLoader.getProjectBudgets(project);
    }

    public void calcPayment() {
        payment = calcPaymentFromProject();
    }
}
