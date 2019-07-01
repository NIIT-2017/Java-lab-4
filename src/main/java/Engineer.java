public class Engineer extends Employee implements WorkTime, Project {
    @Override
    public double calculateSalaryByProject(int projectPaymentPerHour) {
        return workload * projectPaymentPerHour;
    }

    @Override
    public double calculateSalaryByWorkTime() {
        return workload * rate;
    }

    @Override
    protected double calculatePayment(PaymentHelper paymentHelper) {
        return calculateSalaryByWorkTime() + calculateSalaryByProject(paymentHelper.calculateProjectPaymentPerHour(project)) ;
    }
}
