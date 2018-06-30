public class TeamLeader extends Programmer implements Heading{
    protected int employeeNum;              //количество подчиненных
    protected double paymentForOneEmp;      //премия за одного подчиненного

    public TeamLeader(int id, String name, double workTime, double payment, String project,
                      double baseRate, double employeeRating, int employeeNum, double paymentForOneEmp) {
        super(id, name, workTime, payment, project, baseRate, employeeRating);
        this.employeeNum = employeeNum;
        this.paymentForOneEmp = paymentForOneEmp;
    }

    public void setEmployeeNum(int num) {
        employeeNum = num;
    }

    public void setPaymentForOneEmp(int paymentHeading) {
        paymentForOneEmp = paymentHeading;
    }

    public double paymentFromHeading() {
        return employeeNum * paymentForOneEmp;
    }

    @Override
    protected double calcPayment() {
        return paymentFromProject() + paymentFromTime() + paymentFromHeading();
    }
}
