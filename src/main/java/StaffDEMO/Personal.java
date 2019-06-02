package StaffDEMO;

public abstract
class Personal extends Employee implements WorkTime{
    public
    Personal ( Integer id, String name, double worktime, double base ) {
        super(id, name, worktime, base);
        this.salary(worktime, base);
    }

    public
    void salary ( double worktime, double base ) {
        setPayment(worktime * base);
    }
}

class Cleaner extends Personal{
    public
    Cleaner ( Integer id, String name, double worktime, double base ) {
        super(id, name, worktime, base);
    }
}

class Driver extends Personal {
    public
    Driver ( Integer id, String name, double worktime, double base ) {
        super(id, name, worktime, base);
    }
}