package StaffDemo;

import java.util.ArrayList;
import java.util.List;

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

    double allotMoney(double money) {
        try {
            if (restMoney >= money) {
                restMoney -= money;
                return money;
            } else throw new StaffException("not enough money");
        } catch (StaffException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public void addOfficeplankton(List<? extends OfficePlankton> employees) {
        for (OfficePlankton nextEmployee : employees) {
            nextEmployee.setProject(this);
        }
        this.employee.addAll(employees);
    }

    public void setProjectManager(ProjectManager projectManager) {
        projectManager.setProject(this);
        this.projectManager = projectManager;
    }

    public void setTeamLeader(TeamLeader teamLeader) {
        teamLeader.setProject(this);
        this.teamLeader = teamLeader;
    }

    public ArrayList<Employee> getEmployee() {
        return employee;
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
