public class TeamLeader extends Programmer implements Heading {
    long subordinates;
    TeamLeader(String id, String fio, double base, String project, double budget, double portion, long subordinates) {
        super(id, fio, base, project, budget, portion);
        this.subordinates = subordinates;
    }

    public double HeadCalc() {
        double subBase=10;
        return subBase*subordinates;
    }
    @Override
    public double Calc(){
        setPayment( this.HeadCalc()+super.WtCalc()+super.PrCalc() );
        return this.getPayment();
    }
}
