package StaffDemo;

public abstract class Employee {
    static int LALTID=0;
    int ID;
    String [] FIO;
    double payment;

    Employee(String surname, String name, String secondname) {
        this.ID = ++LALTID;
        this.FIO = new String[]{surname, name, secondname};
    }

    abstract public void calcPayment();

    public String[] getFIO() {
        return FIO;
    }

    public int getID() {
        return ID;
    }

    public double getPayment() {
        return payment;
    }
}
