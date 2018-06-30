public abstract class Engineer extends Employee implements WorkTime, Project{
    protected String project;
    protected double baseRate;              //базовая ставка руб./час
    protected double employeeRating;        //вклад в работу

    public Engineer(int id, String name, double workTime, double payment, String project, double baseRate,
                    double employeeRating) {
        super(id, name, workTime, payment);
        this.project = project;
        this.baseRate = baseRate;
        this.employeeRating = employeeRating;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    public double getEmployeeRating() {
        return employeeRating;
    }

    public void setEmployeeRating(double employeeRating) {
        this.employeeRating = employeeRating;
    }
}
