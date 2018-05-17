package StaffDemo;

import java.util.ArrayList;
import java.util.List;
//руководитель направления ведет все проекты которые есть
public class SeniorManager extends Employee {
    private ArrayList<Project> projects;
    private double ratePerProject;
//конструктор для нового
    public SeniorManager(String surname, String name, String secondname) {
        super(surname, name, secondname);
        projects = new ArrayList<Project>();
    }
//конструктор для чтения из файла
    SeniorManager(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }
//расчет ЗП
    private double calcPaymentForHeading() {
        return ratePerProject * projects.size();
    }
//выплата за руководство
    public void calcPayment() {
        payment = calcPaymentForHeading();
    }
//сетеры и гетеры
    public void setRatePerProject(double ratePerProject) {
        if (ratePerProject>0)
            this.ratePerProject = ratePerProject;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Project> getProjects() {
        if (projects.size()==0)
            return null;
        else
            return new ArrayList<Project>(projects);
    }

    public double getRatePerProject() {
        return ratePerProject;
    }

    public static SeniorManager getSeniorManager(ArrayList<Employee> employees) {
        for(Employee next: employees){
            if (next.getClass().getSimpleName().equals("SeniorManager")) {
                return (SeniorManager) next;
            }
        }
        return null;
    }
}
