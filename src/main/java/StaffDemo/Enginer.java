package StaffDemo;

abstract class Enginer extends OfficePlankton implements PaymentForProject, WorkTime {
    private double rate;
    private double workTime;
    private double partOfProject;

    Enginer(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public double calcPaymentWorkTime() {
        return workTime*rate;
    }

    public double calcPaymentForPartOfProject() {
        return getProject().allotMoney(getPartOfProject() * getProject().getBudget());
    }

    private double getPartOfProject() {
        return partOfProject;
    }

    public void setPartOfProject(double partOfProject) {
        this.partOfProject = partOfProject;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setWorkTime(double workTime) {
        this.workTime = workTime;
    }
}
