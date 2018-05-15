package StaffDemo;
//абстракция для инженерного работника
public abstract class Enginer extends OfficePlankton implements PaymentForProject, WorkTime {
//имеет ставку за рабочие часы, отработтаное время, и процент от бюджета проекта в котором занят
    private double ratePerWorkHour;
    private double workHours;
    private double partOfProject;

    Enginer(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }
//расчет за отработанное время
    public double calcPaymentWorkTime() {
        return workHours * ratePerWorkHour;
    }
//расчет за участие в проекте
    public double calcPaymentForPartOfProject() {
        return getProject().allotMoney(getPartOfProject() * getProject().getBudget());
    }
//сетеры и гетеры
    public void setRatePerProject(double partOfProject) {
        this.partOfProject = partOfProject;
    }

    public void setRatePerWorkHour(double rate) {
        this.ratePerWorkHour = rate;
    }

    public void setWorkHours(double workTime) {
        this.workHours = workTime;
    }

    public void setRateDayHours(double rate) {
        this.ratePerWorkHour = rate;
    }

    private double getPartOfProject() {
        return partOfProject;
    }
}
