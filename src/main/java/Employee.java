public abstract class Employee {
    protected int id;
    protected String name;
    protected float worktime;
    protected int rate;
    protected float payment;

    public Employee (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Employee () {
    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getFio() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public float getWorktime() {
        return worktime;
    }

    public void setWorktime (float worktime) {
        this.worktime = worktime;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    protected float getPayment() {
        return payment;
    }
}
