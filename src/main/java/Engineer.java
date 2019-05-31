public abstract class Engineer extends Employee implements WorkTime, Project{
    protected double part;
    protected int projectBudget;
    protected int rate;

    public Engineer(int id, String name, int rate, int projectBudget, double part){
        super(id, name);
        this.rate = rate;
        this.projectBudget = projectBudget;
        this.part = part;
    }

    public int calcPaymentByPart(){
        return ((int)(projectBudget * part));
    }

    public int calcPaymentByRate(){
        return worktime * rate;
    }

    @Override
    public int calcPayment() {
        return calcPaymentByRate() + calcPaymentByPart();
    }
}
