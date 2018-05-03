package StaffDemo;

public abstract class Enginer extends Employee implements PaymentForProject, WorkTime {
    Enginer(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }
    double rate;
    double workTime;

    public Enginer(String id, String surname, String name, String secondname) {
        super(id, surname, name, secondname);
    }
}
