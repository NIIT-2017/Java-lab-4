public class ProjectManager extends Manager implements Heading{
    protected int amountOfSubs;

    public ProjectManager (int id, String name, int projectBudget, double part, int amountOfSubs){
        super(id, name, projectBudget, part);
        this.amountOfSubs = amountOfSubs;
    }

    public int calcPaymentBySubs(){
        return amountOfSubs * PAYMENT_PER_SUBORDINATED;
    }

    @Override
    public int calcPayment() {
        return calcPaymentBySubs() + calcPaymentByPart();
    }
}
