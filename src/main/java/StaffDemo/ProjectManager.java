package StaffDemo;

import java.util.ArrayList;

public class ProjectManager extends Manager implements Heading{
    private double ratePerEmployees;
    public ProjectManager(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public ProjectManager(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }

    public void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentForHeading();
    }

    public double calcPaymentForHeading() {
        int countProgrammersOfProject = Programmer.getProgrammers(getProject().getEmployee()).size();
        int countManagersOfProject    = Manager.getManagers(getProject().getEmployee()).size();
        return getProject().allotMoney(ratePerEmployees * (countManagersOfProject + countProgrammersOfProject + 1));
    }

    public void setRatePerEmployees(double ratePerEmploues) {
        this.ratePerEmployees = ratePerEmploues;
    }

    public static ArrayList<ProjectManager> getProjectManagers(ArrayList<Employee> employees) {
        ArrayList<ProjectManager> newArray = new ArrayList<ProjectManager>();
        for(Employee next: employees){
            if (next.getClass().getSimpleName().equals("ProjectManager")) {
                newArray.add((ProjectManager) next);
            }
        }
        return newArray;
    }
}
