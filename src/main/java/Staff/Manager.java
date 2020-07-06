package Staff;

public class Manager extends Employee implements Project{

    //fields
    private DevelopProjects project;
    //---------------------------------------------------------

    //constructor

    public Manager(int id, String fio, int workTime, DeveloperCompany company) {
        super(id, fio, company);
        this.workTime = workTime;
        position = "Manager";
    }
    //---------------------------------------------------------

    //methods
    public double salaryCalculator() {
        return projectPayment();
    }

    public double projectPayment() {
        if (project!=null && project.isItPossibleToPay())
            return (project.getBudget()*0.6)/(project.getManagers().size()+1);
        else
            return 0;
    }
    //---------------------------------------------------------

    //setters
    public boolean setProject(DevelopProjects project) {
        this.project = project;
        return true;
    }
    //---------------------------------------------------------

    //getters
    public DevelopProjects getProject() {
        return project;
    }
    //---------------------------------------------------------
}
