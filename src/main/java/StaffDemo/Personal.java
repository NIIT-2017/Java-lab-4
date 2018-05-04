package StaffDemo;

public abstract class Personal extends Employee implements WorkTime{

    double dayWorkHours;
    double rateDayHours;

    Personal(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public void setDayWorkHours(double dayWorkHours) {
        this.dayWorkHours = dayWorkHours;
    }

    public void setRateDayHours(double rateDayHours) {
        this.rateDayHours = rateDayHours;
    }

}
