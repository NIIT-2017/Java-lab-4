package StaffDemo;

public abstract class Personal extends Employee implements WorkTime{
    //у персонала только рабочие часы и ставка за час
    private double workHours;
    private double ratePerWorkHour;

    Personal(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public void setWorkHours(double workHours) {
        if (workHours>0)
            this.workHours = workHours;
    }

    public void setRateWorkHour(double ratePerWorkHour) {
        if (ratePerWorkHour>0)
            this.ratePerWorkHour = ratePerWorkHour;
    }

    //расчет ЗП за отработанное время
    public double calcPaymentWorkTime() {
        return ratePerWorkHour * workHours;
    }

    public double getWorkHours() {
        return workHours;
    }

    public double getRatePerWorkHour() {
        return ratePerWorkHour;
    }
}
