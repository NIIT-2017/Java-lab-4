abstract public class Employee {
    int id;
    String name;
    int worktime;
    int payment;

    Employee() {
    }

    Employee(int id, String name, int worktime, int payment) {
        this.id = id;
        this.name = name;
        this.worktime = worktime;
        this.payment = payment;
    }

    abstract int calcPay();
}
