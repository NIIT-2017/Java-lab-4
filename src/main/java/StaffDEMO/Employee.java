package StaffDEMO;

public
abstract class Employee {
    protected Integer id;
    protected String name;
    protected double worktime;
    protected double payment;
    protected double base;

    public
    Employee ( Integer id, String name, double worktime, double base ) {
        this.id = id;
        this.name = name;
        this.worktime = worktime;
        this.payment = 0;
        this.base = base;
    }

    public
    void setPayment ( double payment ) {
        this.payment = payment;
    }

    public
    double getPayment () {
        return payment;
    }
}

interface WorkTime {
    public void salary (double worktime, double base);
}

interface Project {
    public void bonus (double budget, double part);
}

interface Heading {
    public void salary (double base, int employeeNumber);
}



