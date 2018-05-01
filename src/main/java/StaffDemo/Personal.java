package StaffDemo;

public abstract class Personal extends Employee implements WorkTime{

    public Personal(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public void setDayWorkHours(double dayWorkHours) {
        this.dayWorkHours = dayWorkHours;
    }

    double dayWorkHours;
    double ratePerDayHours;

}
