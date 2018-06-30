public class ProjectManager extends Manager implements Heading{
    protected int employeeNum;                  //количество подчиненных
    protected double paymentForOneEmp;          //премия за одного подчиненного

    public ProjectManager(int id, String name, double payment, String project,
                          double employeeRating, int employeeNum, double paymentForOneEmp) {
        super(id, name, payment, project, employeeRating);
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
        return paymentFromProject() + paymentFromHeading();
    }
}
