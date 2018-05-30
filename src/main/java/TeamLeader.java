public class TeamLeader extends Programmer implements Heading {
    protected double rate;
    protected int emplNum;

    TeamLeader(int id, String name, String position, double base, double share, String project, double rate, int emplNum) {
        super(id, name, position, base, share, project);
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
        payment = calcPaymentFromTime();
        payment += calcPaymentFromProject();
        payment += calcPaymentFromHeading();
    }
}
