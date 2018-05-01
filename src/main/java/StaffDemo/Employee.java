package StaffDemo;

abstract class Employee {
    static int LALTID=0;
    int ID;
    String [] FIO;
    double payment;

    public Employee(String surname,String name, String secondname) {
        this.ID = ++LALTID;
        this.FIO = new String[]{surname, name, secondname};
    }

    abstract void calcPayment();

    public double getPayment() {
        return payment;
    }
}
