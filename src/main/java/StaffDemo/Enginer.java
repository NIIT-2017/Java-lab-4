package StaffDemo;
//абстракция для инженерного работника
public abstract class Enginer extends OfficePlankton implements PaymentForProject, WorkTime {
//имеет ставку за рабочие часы, отработтаное время, и процент от бюджета проекта в котором занят
    private double rateWorkHour;
    private double workHours;
    private double partOfProject;

    Enginer(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }
//расчет за отработанное время
    public double calcPaymentWorkTime() {
        return workHours * rateWorkHour;
    }
//расчет за участие в проекте
    public double calcPaymentForPartOfProject() {
        return getProject().allotMoney(getPartOfProject() * getProject().getBudget());
    }
//сетеры и гетеры
    public void setRatePerProject(double partOfProject) {
        if (partOfProject>0)
            this.partOfProject = partOfProject;
    }

    public void setRateWorkHour(double rate) {
        if (rate > 0) {
            this.rateWorkHour = rate;
        }
    }

    public void setWorkHours(double workTime) {
        if (workTime > 0) {
            this.workHours = workTime;
        }
    }

    public double getRateWorkHour() {
        return rateWorkHour;
    }

    public double getWorkHours() {
        return workHours;
    }

    public double getPartOfProject() {
        return partOfProject;
    }
}
