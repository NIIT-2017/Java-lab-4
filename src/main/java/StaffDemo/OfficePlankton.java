package StaffDemo;
//абстрактный класс для всех работников занятых в проектах
abstract class OfficePlankton extends Employee {
    private double ratePerProject;
    private Project project;

    OfficePlankton(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public void setProject(Project project) {
        this.project = project;
    }
    //расчет процента от бюджета проекта
    public double calcPaymentForPartOfProject() {
        if (this.getProject()==null) return 0.0;
        else return ratePerProject *this.getProject().getBudget();
    }
    //сетеры и гетеры
    public void setRatePerProject(double ratePerProject) {
        if (ratePerProject>0)
            this.ratePerProject = ratePerProject;
    }

    double getRatePerProject() {
        return ratePerProject;
    }

    public Project getProject() {
        return project;
    }
}
