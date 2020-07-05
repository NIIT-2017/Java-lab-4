public abstract class Manager extends Employee implements Project{
    protected int finance;

    public Manager(int id, String name, int finance){
        super(id, name);
        this.finance = finance;
    }

    public int CalcProject(){
        return ((int)(finance * 0.1)) ;
    }
}
