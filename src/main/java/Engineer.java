public abstract class Engineer extends Employee implements WorkTime, Project{
    protected int projectBudget;
    protected int rate;

    public Engineer(int id, String name, int rate, int projectBudget){
        super(id, name);
        this.rate          = rate;
        this.projectBudget = projectBudget;
    }

    public int CalcProject(){
        return ((int)(projectBudget * 0.1));
    }

    public int TimeCalc(){
        return worktime * rate;
    }
    @Override
    public int calcPayment(){
        return TimeCalc();
    }
}
