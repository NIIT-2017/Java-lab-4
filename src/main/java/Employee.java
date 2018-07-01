abstract class Employee {
    private int id;
    private String name;
    private double worktime;
    private double payment;

    Employee(int id, String name, double worktime) {
        this.id = id;
        this.name = name.trim();
        this.worktime = worktime;
        payment = 0;
    }

    double getWorktime() {
        return worktime;
    }

    double getPayment() {
        return payment;
    }

    public String getName(){
        return name;
    }

    abstract double calcPayment();

    void setPayment(double payment) {
        this.payment = payment;
    }
}
