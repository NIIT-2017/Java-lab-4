public abstract class Manager extends Employee implements Project{
    protected double part;
    protected int projectBudget;

    public Manager(int id, String name, int projectBudget, double part){
        super(id, name);
        this.projectBudget = projectBudget;
        this.part = part;
    }

    public int calcPaymentByPart(){
        return ((int)(projectBudget * part));
    }
}
