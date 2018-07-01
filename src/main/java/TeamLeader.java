class TeamLeader extends Programmer implements Heading{
    private int amountOfEmployees;
    TeamLeader(int id, String name, double workTime,double payForHour, double bonus,int amountEmployees,String project) {
        super(id, name, workTime,payForHour, bonus, project);
        this.amountOfEmployees = amountEmployees;
    }

    public double calcPaymentByHeading() {
        return payForEmployee * amountOfEmployees;
    }

    @Override
    double calcPayment() {
        return super.calcPayment() + calcPaymentByHeading();
    }
}
