package Staff;

import org.apache.commons.io.IOUtils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;

public class DeveloperCompany {

    //fields
    private String title;
    private int baseRate;
    private SeniorManager seniorManager;
    private ArrayList<ProjectManager> projectManagers = new ArrayList<>();
    private ArrayList<Manager> managers = new ArrayList<>();
    private ArrayList<Cleaner> cleaners = new ArrayList<>();
    private ArrayList<Driver> drivers = new ArrayList<>();
    private ArrayList<Programmer> programmers = new ArrayList<>();
    private ArrayList<Tester> testers = new ArrayList<>();
    private ArrayList<TeamLeader> teamLeaders = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<DevelopProjects> projects = new ArrayList<>();
    //---------------------------------------------------------

    //construcor
    public DeveloperCompany(String title, int baseRate) {
        this.title = title;
        this.baseRate = baseRate;
    }
    //---------------------------------------------------------

    //methods
    public void companyCreation(String jasonFile){
        JSONParser parser = new JSONParser();
        try {

            InputStream inputStream = getClass().getResourceAsStream(jasonFile);
            String inputFile = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONArray empArr = (JSONArray) parser.parse(inputFile);
            Iterator studIter = empArr.iterator();
            while (studIter.hasNext()) {
                JSONObject employee = (JSONObject) studIter.next();
                int id = Integer.parseInt(employee.get("id").toString());
                String fio = employee.get("fio").toString();
                int workTime = Integer.parseInt(employee.get("workTime").toString());
                String position = employee.get("position").toString();
                switch (position){
                    case "cleaner":
                        cleaners.add(new Cleaner(id, fio, workTime, this));
                        employees.add(cleaners.get(cleaners.size()-1));
                        break;
                    case "driver":
                        drivers.add(new Driver(id, fio, workTime, this));
                        employees.add(drivers.get(drivers.size()-1));
                        break;
                    case "programmer":
                        programmers.add(new Programmer(id, fio, workTime, this));
                        employees.add(programmers.get(programmers.size()-1));
                        break;
                    case "tester":
                        testers.add(new Tester(id, fio, workTime, this));
                        employees.add(testers.get(testers.size()-1));
                        break;
                    case "teamLeader":
                        teamLeaders.add(new TeamLeader(id, fio, workTime, this));
                        employees.add(teamLeaders.get(teamLeaders.size()-1));
                        break;
                    case "manager":
                        managers.add(new Manager(id, fio, workTime,this));
                        employees.add(managers.get(managers.size()-1));
                        break;
                    case "projectManager":
                        projectManagers.add(new ProjectManager(id, fio, workTime, this));
                        employees.add(projectManagers.get(projectManagers.size()-1));
                        break;
                    case "seniorManager":
                        seniorManager = new SeniorManager(id, fio, workTime,this);
                        employees.add(seniorManager);
                        break;
                }
            }
            parser.reset();
            empArr.clear();
        } catch (RuntimeException | ParseException | IOException e) {
            e.printStackTrace();
        }
    }
    public void addProjects(String jasonFile){
        JSONParser parser = new JSONParser();
        try {

            InputStream inputStream = getClass().getResourceAsStream(jasonFile);
            String inputFile = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONArray projArr = (JSONArray) parser.parse(inputFile);
            Iterator projIter = projArr.iterator();
            while (projIter.hasNext()) {
                JSONObject project = (JSONObject) projIter.next();
                int id = Integer.parseInt(project.get("id").toString());
                String title = project.get("title").toString();
                int budget = Integer.parseInt(project.get("budget").toString());
                projects.add(new DevelopProjects(id, title, budget, seniorManager));
            }
            parser.reset();
            projArr.clear();
        } catch (RuntimeException | ParseException | IOException e) {
            e.printStackTrace();
        }
    }
    public void assignPerformers(){
        for (DevelopProjects project: projects){
            int i = 0;
            while (!project.setTeamLeader(teamLeaders.get(i++)) && i<teamLeaders.size()) { }
            i = 0;
            while (!project.setProjectManager(projectManagers.get(i++)) && i<projectManagers.size()) { }
            i = 0;
            while (project.getManagers().size() < 2 && i < managers.size()){
                project.setManager(managers.get(i++));
            }
            i = 0;
            while (project.getEngineers().size() < 3 && i < testers.size()){
                project.setEngineer(testers.get(i++));
            }
            i = 0;
            while (project.getEngineers().size() < 7 && i < programmers.size()){
                project.setEngineer(programmers.get(i++));
            }
        }
    }
    public void printAll(){
        for (Employee emp: employees){
            System.out.println(emp.toString());
        }
    }
    public void saveStuff(String file){
        JSONArray stuff = new JSONArray();
        for (Employee employee: employees){
            JSONObject emp = new JSONObject();
            emp.put("id", employee.getId());
            emp.put("fio", employee.getFio());
            emp.put("workTime", employee.getWorkTime());
            emp.put("payment", employee.getPayment());
            emp.put("position", employee.getPosition());
            stuff.add(emp);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(stuff.toString());
        } catch (IOException | RuntimeException e) {
            System.out.println("File not saved");
        }
    }
    public void accrualOfSalary(){  // начисляем зп всем
        for (Employee emp: employees){
            emp.setPayment();
        }
        for (DevelopProjects project: projects){
            if (project.isItPossibleToPay())
                project.closeTheProject();
        }
    }
    public void prepareForPayment(){    // финишируем все проекты
        for (DevelopProjects project: projects){
            project.completeTheProject();
        }
    }
    //---------------------------------------------------------

    //setters
    public void setSeniorManagers(SeniorManager seniorManager) {
        this.seniorManager = seniorManager;
    }
    public void addProjectManagers(ProjectManager projectManager) {
        this.projectManagers.add(projectManager);
    }
    public void addManagers(Manager manager) {
        this.managers.add(manager);
    }
    public void addCleaners(Cleaner cleaner) {
        this.cleaners.add(cleaner);
    }
    public void addDrivers(Driver driver) {
        this.drivers.add(driver);
    }
    public void addProgrammers(Programmer programmer) {
        this.programmers.add(programmer);
    }
    public void addTesters(Tester tester) {
        this.testers.add(tester);
    }
    public void addTeamLeaders(TeamLeader teamLeader) {
        this.teamLeaders.add(teamLeader);
    }
    public void addDevelopProjects(DevelopProjects developProject) {
        this.projects.add(developProject);
    }
    //---------------------------------------------------------

    //getters
    public int getBaseRate(){
        return baseRate;
    }
    public SeniorManager getSeniorManager() {
        return seniorManager;
    }
    public ArrayList<ProjectManager> getProjectManagers() {
        return projectManagers;
    }
    public ArrayList<Manager> getManagers() {
        return managers;
    }
    public ArrayList<Cleaner> getCleaners() {
        return cleaners;
    }
    public ArrayList<Driver> getDrivers() {
        return drivers;
    }
    public ArrayList<Programmer> getProgrammers() {
        return programmers;
    }
    public ArrayList<Tester> getTesters() {
        return testers;
    }
    public ArrayList<TeamLeader> getTeamLeaders() {
        return teamLeaders;
    }
    public ArrayList<DevelopProjects> getDevelopProjects() {
        return projects;
    }
    public int getNumberOfEmployee(){ return employees.size();}
    //---------------------------------------------------------
}
