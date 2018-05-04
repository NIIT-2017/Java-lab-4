package StaffDemo;


public abstract class Employee {
    private static int LALTID=0;
    private int ID;
    private String [] FIO;
    protected double payment;

    Employee(String surname, String name, String secondname) {
        this.ID = ++LALTID;
        this.FIO = new String[]{surname, name, secondname};
    }

    abstract public void calcPayment();

    protected void setID(int ID) {
        this.ID = ID;
    }

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
