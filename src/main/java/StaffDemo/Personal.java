package StaffDemo;

public abstract class Personal extends Employee implements WorkTime{

    Personal(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public Personal(String id, String surname, String name, String secondname) {
        super(id, surname, name, secondname);
    }

    public void setDayWorkHours(double dayWorkHours) {
        this.dayWorkHours = dayWorkHours;
    }

    public void setRatePerDayHours(double ratePerDayHours) {
        this.ratePerDayHours = ratePerDayHours;
    }

    double dayWorkHours;
    double ratePerDayHours;

}
