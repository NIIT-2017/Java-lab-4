package StaffDemo;

public abstract class Personal extends Employee implements WorkTime{

    double workHours;
    double ratePerWorkHour;

    Personal(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }

    public void setRatePerWorkHour(double ratePerWorkHour) {
        this.ratePerWorkHour = ratePerWorkHour;
    }

}
