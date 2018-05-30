public class ProjectManager extends Manager implements Heading {
    protected double rate;
    protected int emplNum;

    ProjectManager(int id, String name, String position, double share, String project, double rate, int emplNum) {
        super(id, name, position, share, project);
        this.rate = rate;
        this.emplNum = emplNum;
    }

    public void setPatePerEmployee(double rate) {this.rate = rate;}
    public void setEmployeeNum(int emplNum) {this.emplNum = emplNum;}

    public double getRate() {return rate;}
    public int getEmplNum() {return emplNum;}

    public double calcPaymentFromHeading() {
        return rate * emplNum;
    }

    @Override
    public void calcPayment() {
        payment = calcPaymentFromProject() + calcPaymentFromHeading();
    }
}
