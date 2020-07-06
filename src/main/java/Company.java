import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Company {
    public ArrayList<Cleaner> allCleaners = new ArrayList<>();
    public ArrayList<Driver> allDrivers = new ArrayList<>();
    public ArrayList<ProjectManager> allProjectManagers = new ArrayList<>();
    public ArrayList<Manager> allManagers = new ArrayList<>();
    public ArrayList<TeamLeader> allTTeamLeaders = new ArrayList<>();
    public ArrayList<Programmer> allProgrammers = new ArrayList<>();
    public ArrayList<Tester> allTesters = new ArrayList<>();
    public ArrayList<SeniorManager> allSeniorManagers = new ArrayList<>();
    public HashMap<String, Integer> allProjects = new HashMap<>();

    protected void createEmployees(String fileName) {
        String stringOfList;
        JSONArray staff;
        try {
            File file = new File(getClass().getClassLoader().getResource(fileName).getFile()
            );
            stringOfList = FileUtils.readFileToString(file, "utf-8");
            staff = new JSONArray(stringOfList);
        } catch (IOException ex) {
            System.out.println("Error during reading " + fileName + ex.getMessage());
            return;
        }
        for (int i = 0; i < staff.length(); i++) {
            JSONObject staffJSON = (JSONObject) staff.get(i);
            String position = (String) staffJSON.get("position");
            String name = (String) staffJSON.get("name");
            if (position.equals("Cleaner")) {
                Cleaner newCleaner = new Cleaner();
                newCleaner.setName(name);
                int id = (int) staffJSON.get("id");
                newCleaner.setId(id);
                newCleaner.setPosition(position);
                int payment = (int) staffJSON.get("base");
                newCleaner.setRate(payment);
                allCleaners.add(newCleaner);
            }
            if (position.equals("Driver")) {
                Driver newDriver = new Driver();
                newDriver.setName(name);
                int id = (int) staffJSON.get("id");
                newDriver.setId(id);
                newDriver.setPosition(position);
                int payment = (int) staffJSON.get("base");
                newDriver.setRate(payment);
                allDrivers.add(newDriver);
            }
            if (position.equals("Senior Manager")) {
                SeniorManager newSeniorSeniorManager = new SeniorManager();
                newSeniorSeniorManager.setName(name);
                int id = (int) staffJSON.get("id");
                newSeniorSeniorManager.setId(id);
                newSeniorSeniorManager.setPosition(position);
                allSeniorManagers.add(newSeniorSeniorManager);
            }
            if (position.equals("Project Manager")) {
                ProjectManager newProjectManager = new ProjectManager();
                newProjectManager.setName(name);
                int id = (int) staffJSON.get("id");
                newProjectManager.setId(id);
                newProjectManager.setPosition(position);
                String project = (String) staffJSON.get("project");
                newProjectManager.setProject(project);
                allProjectManagers.add(newProjectManager);
            }
            if (position.equals("Manager")) {
                Manager newManager = new Manager();
                newManager.setName(name);
                int id = (int) staffJSON.get("id");
                newManager.setId(id);
                newManager.setPosition(position);
                String project = (String) staffJSON.get("project");
                newManager.setProject(project);
                allManagers.add(newManager);
            }
            if (position.equals("Team Leader")) {
                TeamLeader newTeamLeader = new TeamLeader();
                newTeamLeader.setName(name);
                int id = (int) staffJSON.get("id");
                newTeamLeader.setId(id);
                newTeamLeader.setPosition(position);
                int payment = (int) staffJSON.get("base");
                newTeamLeader.setRate(payment);
                String project = (String) staffJSON.get("project");
                newTeamLeader.setProject(project);
                allTTeamLeaders.add(newTeamLeader);
            }
            if (position.equals("QA")) {
                Tester newTester = new Tester();
                newTester.setName(name);
                int id = (int) staffJSON.get("id");
                newTester.setId(id);
                newTester.setPosition(position);
                int payment = (int) staffJSON.get("base");
                newTester.setRate(payment);
                String project = (String) staffJSON.get("project");
                newTester.setProject(project);
                allTesters.add(newTester);
            }
            if (position.equals("Programmer")) {
                Programmer newProgrammer = new Programmer();
                newProgrammer.setName(name);
                int id = (int) staffJSON.get("id");
                newProgrammer.setId(id);
                newProgrammer.setPosition(position);
                int payment = (int) staffJSON.get("base");
                newProgrammer.setRate(payment);
                String project = (String) staffJSON.get("project");
                newProgrammer.setProject(project);
                allProgrammers.add(newProgrammer);
            }
        }
    }

    public ArrayList<Cleaner> getAllCleaners() {
        return allCleaners;
    }

    public ArrayList<Driver> getAllDrivers() {
        return allDrivers;
    }

    public ArrayList<Manager> getAllManegers() {
        return allManagers;
    }

    public ArrayList<ProjectManager> getAllProjectManagers() {
        return allProjectManagers;
    }

    public ArrayList<TeamLeader> getAllTTeamLeaders() {
        return allTTeamLeaders;
    }

    public ArrayList<Tester> getAllTesters() {
        return allTesters;
    }

    public ArrayList<Programmer> getAllProgrammers() {
        return allProgrammers;
    }

    public ArrayList<SeniorManager> getAllSeniorManagers() {
        return allSeniorManagers;
    }

    protected void readProjectsList (String fileName) {
        try {
            File file = new File(getClass().getClassLoader().getResource(fileName).getFile()
            );
            String stringOfList = FileUtils.readFileToString(file, "utf-8");
            JSONArray projectList = new JSONArray(stringOfList);
            for (int i = 0; i < projectList.length(); i++) {
                JSONObject projectJSON = (JSONObject) projectList.get(i);
                String projectName = (String) projectJSON.get("name");
                Integer projectBudget = (Integer) projectJSON.get("budget");
                allProjects.put(projectName, projectBudget);
            }
        } catch (IOException ex) {
            System.out.println("Error during reading " + fileName + ex.getMessage());
        }
    }

    public HashMap getAllProjects() {
        return allProjects;
    }

    public float getBudget(String project) {
        return (float) allProjects.get(project);
    }

    public int getNumberOfEmployeesInProject(String project) {
        int numberOfEmployeesInProject = 0;
        for (int m = 0; m<allManagers.size(); m++) {
            if (project.equals(allManagers.get(m).getProject())) {
                numberOfEmployeesInProject++;
            }
        }
        for (int pm = 0; pm<allProjectManagers.size(); pm++) {
            if (project.equals(allProjectManagers.get(pm).getProject())) {
                numberOfEmployeesInProject++;
            }
        }
        for (int tl = 0; tl<allTTeamLeaders.size(); tl++) {
            if (project.equals(allTTeamLeaders.get(tl).getProject())) {
                numberOfEmployeesInProject++;
            }
        }
        numberOfEmployeesInProject += getNumberOfProgrammersInProject(project);
        numberOfEmployeesInProject += getNumberOfTestersInProject(project);
        return numberOfEmployeesInProject;
    }

    public int getNumberOfProgrammersInProject(String project) {
        int numberOfProgrammersInProject = 0;
        for (int p = 0; p < allProgrammers.size(); p++) {
            if (project.equals(allProgrammers.get(p).getProject())) {
                numberOfProgrammersInProject++;
            }
        }
        return numberOfProgrammersInProject;
    }

    public int getNumberOfTestersInProject(String project) {
        int numberOfTestersInProject = 0;
        for (int p = 0; p < allTesters.size(); p++) {
            if (project.equals(allTesters.get(p).getProject())) {
                numberOfTestersInProject++;
            }
        }
        return numberOfTestersInProject;
    }

    public int getNumberOfEmployeesInCompany() {
        int numberOfEmployeesInCompany = getAllCleaners().size() + getAllDrivers().size() + getAllManegers().size() + getAllProjectManagers().size()
                + getAllTTeamLeaders().size() + getAllProgrammers().size() + getAllTesters().size() + getAllSeniorManagers().size();
        return numberOfEmployeesInCompany;
    }

}





