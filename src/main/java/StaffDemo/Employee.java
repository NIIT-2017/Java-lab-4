package StaffDemo;
//основные поля и методы для работников
public abstract class Employee {

//    номер работника
    private int ID;
//    фамилия имя отчество
    private String [] FIO;
    protected double payment;

    Employee(String surname, String name, String secondname) {
            this.FIO = new String[]{surname, name, secondname};
    }
//все наследники должны реализовать расчет ЗП
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
