package Staff;

import java.util.ArrayList;

public class SeniorManager extends ProjectManager {

    //fields
    private ArrayList<ProjectManager> projectManagers;
    //---------------------------------------------------------

    //constructor

    public SeniorManager(int id, String fio, int workTime, DeveloperCompany company) {
        super(id, fio, workTime, company);
        position = "Senior Manager";
    }
    //---------------------------------------------------------

    //methods
    @Override
    public double projectPayment(DevelopProjects project) {
        if (project.isItPossibleToPay())
            return project.getBudget()*0.05;
        else
            return 0;
    }
    @Override
    public double managementFee(DevelopProjects project) {
        double surcharge = 1 + (((double)company.getProjectManagers().size() * 3)/100);
        if (surcharge >= 1.2)
            surcharge=1.2;
        return surcharge;
    }
    //---------------------------------------------------------

    //setters
    public void setProjectManagers(ArrayList<ProjectManager> projectManagers) {
        this.projectManagers = projectManagers;
    }
    //---------------------------------------------------------

    //getters
    public ArrayList<ProjectManager> getProjectManagers() {
        return projectManagers;
    }
    //---------------------------------------------------------
}
