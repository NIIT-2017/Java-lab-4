public abstract class Employee {
    protected int id;
    protected String name; // surname and initials
    protected int worktime; // in hours
    protected int payment; //salary per month
    protected String position;

    public Employee (int id, String name){
        this.id = id;
        this.name = name;
        this.position = this.getClass().toString().split(" ")[1];
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

    public void setPayment(){
            this.payment = calcPayment();
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    abstract protected int calcPayment();
}
