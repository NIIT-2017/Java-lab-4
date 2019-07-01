public class TeamLeader extends Programmer implements Heading {
    public TeamLeader(Employee employee) {
        super(employee);
        this.personrate = employee.personrate;
    }

    @Override
    public double calculateSalaryByHeading(int projectCount) {
        return projectCount * personrate;
    }

    @Override
    protected double calculatePayment(PaymentHelper paymentHelper) {
        return calculateSalaryByWorkTime()
                + calculateSalaryByProject(paymentHelper.calculateProjectPaymentPerHour(project))
                + calculateSalaryByHeading(paymentHelper.calculateProjectCount(project)) ;
    }
}
