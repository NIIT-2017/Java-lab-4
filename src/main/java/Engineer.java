abstract class Engineer extends Employee implements  WorkTIme, Project{

    private double paymentForHour;
    private double bonusOfProject;
    private String project;

    Engineer(int id, String name, double workTime, double paymentForHour, double bonus, String project) {
        super(id, name, workTime);
        this.paymentForHour = paymentForHour;
        this.bonusOfProject = bonus / 100;
        this.project = project;
    }

    public String getProject() {
        return project;
    }

    public double calcPaymentByProject() {
        return projectsCost[projects.valueOf(project).ordinal()] * bonusOfProject;
    }

    public double calcPaymentByWorkTime() {
        return getWorktime() * paymentForHour;
    }
}
