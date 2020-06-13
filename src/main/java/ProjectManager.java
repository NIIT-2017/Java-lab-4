public class ProjectManager extends Manager {

    private int project;                                        // проект
    private int worktime;                                       // отработанное время
    private int payment;                                        // заработная плата

    ProjectManager (int id, String name, String position, int project) {
        super(id, name, position);
        this.project = project;
    }

    public int calculateProjectSalary() {
        payment = (int) ((project*0.035));
        return payment;}

    public int calculateSalary() {
        int  salary = calculateProjectSalary();
        return salary;
    }
}
