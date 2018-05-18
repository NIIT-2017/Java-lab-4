package StaffDemo;

import java.util.ArrayList;
import java.util.List;
//проект в котором заняты рабочие
public class Project {
    private ArrayList<Employee> employee;
    private TeamLeader teamLeader;
    private ProjectManager projectManager;
    private String name;
    private double budget;
    private double restMoney;

    public Project(String name, double budget) {
        this.name = name;
        this.budget = budget;
        this.restMoney = budget;
        employee = new ArrayList<Employee>();
    }
//зарезервировать деньги из бюджета проекта если достаточно то вернуть сумму
//    если нет денег то исключение
    double allotMoney(double money) {
        if (money > 0) {
            if (restMoney >= money) {
                restMoney -= money;
                return money;
            }
            else return 0.0;
        }
        else return 0.0;
    }
//назначить на проект работника
    public void addOfficeplankton(List<? extends OfficePlankton> employees) {
        if (employees!=null) {
            for (OfficePlankton nextEmployee : employees) {
                nextEmployee.setProject(this);
            }
            this.employee.addAll(employees);
        }
    }
//назначить руководителя проекта
    public void setProjectManager(ProjectManager projectManager) {
        if (projectManager != null) {
            projectManager.setProject(this);
            this.projectManager = projectManager;
        }
    }
//назначить лидера
    public void setTeamLeader(TeamLeader teamLeader) {
        if (teamLeader != null) {
            teamLeader.setProject(this);
            this.teamLeader = teamLeader;
        }
    }
//сетеры и гетеры
    public ArrayList<Employee> getEmployee() {
        if (employee.size()>0) return employee;
        else return null;

    }

    double getBudget() {
        return budget;
    }

    public TeamLeader getTeamLeader() {
        return teamLeader;
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public String getName() {
        return name;
    }
}
