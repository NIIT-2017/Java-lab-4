package StaffDemo;

public abstract class Personal extends Employee implements WorkTime{
    //у персонала только рабочие часы и ставка за час
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
    //расчет ЗП за отработанное время
    public double calcPaymentWorkTime() {
        return ratePerWorkHour * workHours;
    }
}
