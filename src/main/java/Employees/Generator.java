package Employees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    private static ArrayList<String> names, surnames, projectsTitles,companysNames;

    static {
        try {
            names = readFileToArray("names.txt");
            surnames = readFileToArray("surnames.txt");
            projectsTitles = readFileToArray("projectsTitles.txt");
            companysNames=readFileToArray("companysNames.txt");
        } catch (Exception ex) {
        }
    }

    private static int nextRandom(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    private static String getRandomString(ArrayList<String> arr) {
        int random = nextRandom(0, arr.size());
        return arr.get(random);
    }

    public static ArrayList<String> readFileToArray(String fileName) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = Paths.get(classLoader.getResource(fileName).toURI()).toFile();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        ArrayList<String> arrayList = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            arrayList.add(line);
        }
        return arrayList;
    }

    public static Employee generateEngineer() {
        return new Engineer(getRandomString(names), getRandomString(surnames), nextRandom(10, 50));
    }

    public static Employee generateProgrammer() {
        return new Programmer(getRandomString(names), getRandomString(surnames), nextRandom(10, 70));
    }

    public static Employee generateTester() {
        return new Tester(getRandomString(names), getRandomString(surnames), nextRandom(10, 40));
    }

    public static Employee generateCleaner() {
        return new Cleaner(getRandomString(names), getRandomString(surnames), nextRandom(100, 150));
    }

    public static Employee generateDriver() {
        return new Driver(getRandomString(names), getRandomString(surnames), nextRandom(120, 200));
    }

    public static Manager generateManager() {
        return new Manager(getRandomString(names), getRandomString(surnames));
    }

    public static TeamLeader generateTeamLeader() {
        return new TeamLeader(getRandomString(names), getRandomString(surnames), nextRandom(300, 500), nextRandom(1000, 2000));
    }

    public static Employee generateProjectManager() {
        return new ProjectManager(getRandomString(names), getRandomString(surnames),nextRandom(3000,7000));
    }

    public static Employee generateSeniorManager() {
        return new SeniorManager(getRandomString(names), getRandomString(surnames),nextRandom(4000,10000));
    }

    public static Project generateProject() {
        ProjectManager projectManager = (ProjectManager) generateProjectManager();
        Project project = new Project(getRandomString(projectsTitles), projectManager, nextRandom(1000000, 500000000), nextRandom(100000, 2000000));
        projectManager.setProject(project);
        generateTeam(project, Engineer.class, projectManager);
        generateTeam(project, Programmer.class, projectManager);
        generateTeam(project, Tester.class, projectManager);
        project.generateEmployeesPartitionPoints();
        return project;
    }

    public static <T extends Employee> void generateTeam(Project project, Class _class, ProjectManager projectManager) {
        int managersNumber = nextRandom(2, 5);
        Manager generalManager = generateManager();
        generalManager.setManager(projectManager);
        generalManager.setProject(project);
        for (int i = 0; i < managersNumber; i++) {
            Manager manager = generateManager();
            manager.setManager(generalManager);
            manager.setProject(project);
            for (int j = 0; j < 5; j++) {
                T employee = (T) generateEmployee(_class);
                employee.setManager(manager);
                employee.setWorkTime(nextRandom(10,1000));
                employee.setProject(project);
            }
        }
    }
    public static <T extends Employee> void generatePersonel(Class _class,ArrayList<Personal> personal) {
        int personelNumber = nextRandom(2, 5);
        for (int i = 0; i < personelNumber; i++) {
                T employee = (T) generateEmployee(_class);
                employee.setWorkTime(nextRandom(10,1000));
                personal.add((Personal) employee);
            }
        }

    public static Employee generateEmployee(Class _class) {
        if (_class == Engineer.class)
            return generateEngineer();
        if (_class == Cleaner.class)
            return generateCleaner();
        if (_class == Driver.class)
            return generateDriver();
        if (_class == Manager.class)
            return generateManager();
        if (_class == Programmer.class)
            return generateProgrammer();
        if (_class == ProjectManager.class)
            return generateProjectManager();
        if (_class == SeniorManager.class)
            return generateSeniorManager();
        if (_class == TeamLeader.class)
            return generateTeamLeader();
        if (_class == Tester.class)
            return generateTester();

        return null;
    }

    public static Company generateCompany() {
        Company company=new Company();
        company.setTitle(getRandomString(companysNames));
        company.addProject(generateProject());
        generatePersonel(Driver.class,company.getPersonal());
        generatePersonel(Cleaner.class,company.getPersonal());
        return  company;
    }
}
