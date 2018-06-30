public abstract class Employee {
    protected int id;               //id работника
    protected String name;          //ФИО
    protected double workTime;      //отработанное время
    protected double payment;       //зарплата

    public Employee(int id, String name, double workTime, double payment) {
        this.id = id;
        this.name = name;
        this.workTime = workTime;
        this.payment = payment;
    }

    public Employee(int id, String name, double payment) {
        this.id = id;
        this.name = name;
        this.payment = payment;
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

    public double getWorkTime() {
        return workTime;
    }

    public void setWorkTime(double workTime) {
        this.workTime = workTime;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    protected abstract double calcPayment();

    @Override
    public String toString() {
        return getClass().getName() + ": " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workTime=" + workTime +
                ", payment=" + payment +
                '}';
    }

}
