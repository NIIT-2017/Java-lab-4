public abstract class Employee {

    protected int id;
    protected String name;
    protected int worktime;
    protected int payment;
    protected String position;

    Employee(int id, String name, String position, int worktime) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.worktime = worktime;
    }

    public int getId() {
        return id;
    }

    public int getPayment() {
        return payment;
    }

    public int getWorktime() {
        return worktime;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    abstract int calc();
}