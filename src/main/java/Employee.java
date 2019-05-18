public abstract class Employee {
    protected int id;
    protected String name;
    protected int worktime;
    protected int payment;
    public Employee(int id, String name){
        this.id=id;
        this.name=name;
    }
    abstract void calc();
}
