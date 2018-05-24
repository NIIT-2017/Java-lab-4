class TeamLeader extends Programmer implements Heading {
    private int amountOfEmploy;
    TeamLeader(int id, String name, double worktime, double payForHour, double bonus,int amountEmploy,String project){
        super(id,name,worktime,payForHour,bonus,project);
        this.amountOfEmploy=amountEmploy;
    }

    public double calcPaymentByHeading() {
        return payForEmploy*amountOfEmploy;
    }


    @Override
    double CalcPayment() {
        return super.CalcPayment()+calcPaymentByHeading();
    }
}
