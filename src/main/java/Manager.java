public class Manager extends Employee implements Project{
    protected String project;
    protected double employeeRating;        //вклад в работу

    public Manager(int id, String name, double payment, String project, double employeeRating) {
        super(id, name, payment);
        this.project = project;
        this.employeeRating = employeeRating;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public double getEmployeeRating() {
        return employeeRating;
    }

    public void setEmployeeRating(double employeeRating) {
        this.employeeRating = employeeRating;
    }

    public double paymentFromProject() {
        return employeeRating * StaffReader.getBudgetProject(project);
    }

    @Override
    protected double calcPayment() {
        return paymentFromProject();
    }
}
