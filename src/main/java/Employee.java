abstract class Employee {
    private long id;
    private String name;
    private long workTime;
    double base;
    private int payment;

    Employee(long id, String name, long workTime, double base,int payment){
        this.id=id;
        this.name=name;
        this.workTime=workTime;
        this.base=base;
        this.payment=payment;
    }

    public long getId() {return id;}
    public String getName() {return name;}
    public long getWorkTime() {return workTime;}
    public int getPayment() {return payment;}
    public double getBase() {return base;}

    public void setId(long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setWorkTime(long workTime) {this.workTime = workTime;}
    public void setPayment(int payment) {this.payment = payment;}
    public void setBase(double base) {this.base = base;}

    abstract public double calcPayment();
}

interface WorkTime {
    double payForHours();
}

interface Project {
    int budgetOfProject1 = 15000000;
    int budgetOfProject2 = 14000000;
    int budgetOfProject3 = 20000000;
    double payForProject();
}

interface Heading {
    int payForHeading();
}