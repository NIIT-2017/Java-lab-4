public abstract class Employee {
    protected int id;
    protected String name;
    protected String position;
    protected double time;
    protected double payment;

    Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
        time = 0.0d;
        payment = 0.0d;
    }

    protected void setId(int id) {this.id = id;}
    protected void setName(String name) {this.name = name;}
    protected void setPosition(String position) {this.position = position;}
    protected void setTime(double time) {this.time = time;}

    protected int getId() {return id;}
    protected String getName() {return name;}
    protected String getPosition() {return position;}
    protected double getTime() {return time;}
    protected double getPayment() {return payment;}

    abstract public void calcPayment();
}
