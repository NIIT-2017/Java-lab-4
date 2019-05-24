public abstract class Employee {
    protected int id;
    protected String name;
    protected float worktime;
    protected float payment;

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    protected abstract float calcSalary();
}
