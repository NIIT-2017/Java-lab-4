public class ProjectManager extends Manager implements Heading {
    public ProjectManager(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.workload = employee.workload;
        this.rate = employee.rate;
        this.project = employee.project;
        this.budget = employee.budget;
        this.personrate = employee.personrate;
    }
    @Override
    public double calculateSalaryByProject(int projectPaymentPerHour) {
        return workload * projectPaymentPerHour;
    }

    @Override
    protected double calculatePayment(PaymentHelper paymentHelper) {
        return calculateSalaryByProject(paymentHelper.calculateProjectPaymentPerHour(this.project))
                + calculateSalaryByHeading(paymentHelper.calculateProjectCount(project));
    }

    @Override
    public double calculateSalaryByHeading(int projectCount) {
        return projectCount * personrate;
    }
}
