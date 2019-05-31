public class TeamLeader extends Programmer implements Heading{
    protected int amountOfSubs;

    public TeamLeader(int id, String name, int rate, int projectBudget, double part, int amountOfSubs){
        super(id, name, rate, projectBudget, part);
        this.amountOfSubs = amountOfSubs;
    }

    public int calcPaymentBySubs(){
        return amountOfSubs * PAYMENT_PER_SUBORDINATED;
    }

    @Override
    public int calcPayment(){
        return calcPaymentBySubs() + super.calcPayment();
    }
}
