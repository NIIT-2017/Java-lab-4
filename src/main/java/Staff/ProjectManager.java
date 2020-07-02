package Staff;

import java.util.ArrayList;

public class ProjectManager extends Manager implements Heading{

    //fields
    protected ArrayList<DevelopProjects> projects = new ArrayList<>();
    //---------------------------------------------------------

    //constructor

    public ProjectManager(int id, String fio, int workTime, DeveloperCompany company) {
        super(id, fio, workTime, company);
        position = "Project Manager";
    }
    //---------------------------------------------------------

    //methods
    @Override
    public double salaryCalculator() {
        double salary = 0;
        if (!projects.isEmpty()) {
            for (DevelopProjects project : projects) {
                salary += projectPayment(project) * managementFee(project);
            }
        }
        return salary;
    }
    public double projectPayment(DevelopProjects project) {
        if (project.isItPossibleToPay())
            return (project.getBudget()*0.6)/(project.getManagers().size()+1);
        else
            return 0;
    }
    public double managementFee(DevelopProjects project) {
        double surcharge = 1 + ((double)project.getManagers().size() * 15)/100;
        if (surcharge >= 1.5)
            surcharge=1.5;
        return surcharge;
    }
    //---------------------------------------------------------

    //setters
    public boolean setProject(DevelopProjects project) {
        if (project.getProjectManager() == null) {
            this.projects.add(project);
            return true;
        }
        else{
            System.out.println("This project already has the project manager");
            return false;
        }
    }
    //---------------------------------------------------------

    //getters
    public ArrayList<DevelopProjects> getProjects() {
        return projects;
    }
    //---------------------------------------------------------
}
