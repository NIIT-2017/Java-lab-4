abstract class Employee {
    private  int id;
    private  String name;
    private  int worktime;
    private int payment;
    private String position;
    private int base;


    public abstract void calc();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWorktime() {
        return worktime;
    }

    public int getPayment() {
        return payment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
}
