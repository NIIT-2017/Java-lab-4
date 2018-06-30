public class SeniorManager extends ProjectManager{
    private double baseRate;

    public SeniorManager(int id, String name, double payment, String project, double employeeRating,
                         int employeeNum, double paymentForOneEmp, double workTime, double baseRate) {
        super(id, name, payment, project, employeeRating, employeeNum, paymentForOneEmp);
        this.workTime = workTime;
        this.baseRate = baseRate;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    public double paymentFromTime() {
        return getWorkTime() * baseRate;
    }

    @Override
    protected double calcPayment() {
        return paymentFromProject() + paymentFromTime() + paymentFromHeading();
    }
}
