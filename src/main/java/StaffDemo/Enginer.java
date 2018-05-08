package StaffDemo;

public abstract class Enginer extends OfficePlankton implements PaymentForProject, WorkTime {
    private double ratePerWorkHour;
    private double workHours;
    private double partOfProject;

    Enginer(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public double calcPaymentWorkTime() {
        return workHours * ratePerWorkHour;
    }

    public double calcPaymentForPartOfProject() {
        return getProject().allotMoney(getPartOfProject() * getProject().getBudget());
    }

    private double getPartOfProject() {
        return partOfProject;
    }

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
}
