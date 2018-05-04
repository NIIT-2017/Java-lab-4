package StaffDemo;

public abstract class Enginer extends Employee implements PaymentForProject, WorkTime {
    private double rate;
    private double workTime;
    private Project project;
    private double partOfProject;

    Enginer(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    Enginer(String id, String surname, String name, String secondname) {
        super(id, surname, name, secondname);
    }

    public double calcPaymentWorkTime() {
        return workTime*rate;
    }

    public double calcPaymentForPartOfProject() {
        return getProject().allotMoney(getPartOfProject() * getProject().getBudget());
    }

    Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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
