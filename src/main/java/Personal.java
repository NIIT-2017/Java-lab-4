public class Personal extends Employee implements WorkTime {

    @Override
    public double calculateSalaryByWorkTime() {
        return workload * rate;
    }

    @Override
    protected double calculatePayment(PaymentHelper paymentHelper) {
        return calculateSalaryByWorkTime();
    }
}
