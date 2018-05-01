package StaffDemo;

public abstract class Enginer extends Employee implements PaymentForProject, WorkTime {
    public Enginer(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }
    double rate;
    double workTime;

}
