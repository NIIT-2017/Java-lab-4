public class Tester extends Engineer{
    public Tester(int id, String name, double workTime, double payment, String project,
                  double baseRate, double employeeRating) {
        super(id, name, workTime, payment, project, baseRate, employeeRating);
    }

    public double paymentFromProject() {
        return employeeRating * StaffReader.getBudgetProject(project);
    }

    public double paymentFromTime() {
        return baseRate * workTime;
    }

    @Override
    protected double calcPayment() {
        return paymentFromProject() + paymentFromTime();
    }
}
