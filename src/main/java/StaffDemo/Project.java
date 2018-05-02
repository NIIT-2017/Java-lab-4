package StaffDemo;

import java.util.ArrayList;

public class Project {
    ArrayList<Programmer> programmers;
    ArrayList<Manager> managers;
    ArrayList<Tester> testers;
    TeamLeader teamLeader;
    ProjectManager projectManager;
    String name;
    double budget;

    public Project(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    double allotMoney(double money) {
        try {
            if (budget >= money) {
                budget -= money;
                return money;
            } else throw new StaffException("not enough money");
        } catch (StaffException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public void setTeamLeader(TeamLeader teamLeader) {
        teamLeader.setProject(this);
        this.teamLeader = teamLeader;
    }

    public void addProgrammers(Programmer programmer, double part) {
        programmer.addWork(this,part);
        programmers.add(programmer);
    }

    public void addManager(Manager manager) {
        manager.setProject(this);
        managers.add(manager);
    }

    public void addTester(Tester tester) {
        tester.setProject(this);
        testers.add(tester);
    }

    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }

    public int getCountProgramers() {
        return programmers.size();
    }

    public int getCountManagers() {
        return managers.size();
    }

    public int getCountTesters() {
        return testers.size();
    }

}
