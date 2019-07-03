abstract class Employee {
    protected int id;
    protected String name;
    protected int worktime;
    protected int payment;


    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.worktime = 0;
        this.payment = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorktime() {
        return worktime;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    abstract void calc();
}
