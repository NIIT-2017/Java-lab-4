package StaffDemo;

import java.util.ArrayList;
//менеджер проекта
public class ProjectManager extends Manager implements Heading{
//    получает за каждого работника и за участие в проекте
    private double ratePerEmployees;
//конструктор для нового
    public ProjectManager(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }
//конструктор для чтения из файла
    ProjectManager(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }
//расчет ЗП за участие в проекте и за руководство проектом
    public void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentForHeading();
    }
//расчет за руководство
    public double calcPaymentForHeading() {
        int countProgrammersOfProject = Programmer.getProgrammers(getProject().getEmployee()).size();
        int countManagersOfProject    = Manager.getManagers(getProject().getEmployee()).size();
        int countTestersOfProject     = Tester.getTesters(getProject().getEmployee()).size();
        return getProject().allotMoney(ratePerEmployees * (countManagersOfProject + countProgrammersOfProject + countTestersOfProject + 1));
    }
//сетер
    public void setRatePerEmployees(double ratePerEmploues) {
        if (ratePerEmploues>0)
            this.ratePerEmployees = ratePerEmploues;
    }

    public double getRatePerEmployees() {
        return ratePerEmployees;
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
