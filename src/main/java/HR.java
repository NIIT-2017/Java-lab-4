import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

class HR
{
    private static ArrayList<Draft> drafts;
    private static ArrayList<Employee> employees;
    public static String work() { //work of human resources
        load();
        calc();
        write();
        return getInfo();
    }
    public static String getInfo() { //collect information about employees' salaries
        String info = "";
        if (checkEmployeesNotNull()) {
            info += "--------------------------------------------------------------------------------------------------------------------------\n";
            info += "| ID       | FULLNAME                               | POSITION           | WORKTIME | PROJECT            | SALARY        |\n";
            info += "--------------------------------------------------------------------------------------------------------------------------\n";
            int[] maxColLen = {11,41,21,11,21,16};
            for (Employee employee : employees) {
                String[] empData = {
                    "| " + Integer.toString(employee.getId()),
                    "| " + employee.getFName(),
                    "| " + employee.getPosition(),
                    "| " + String.format("%(.2f", employee.getWorkTime()),
                    "| " + employee.getProject(),
                    "| " + String.format("%(.2f", employee.getSalary())
                };
                for(int i=0; i < empData.length; i++) {
                    info += empData[i];
                    for(int j=0; j < maxColLen[i] - empData[i].length(); j++) {
                        info += " ";
                    }
                }
                info += "|\n";
                info += "--------------------------------------------------------------------------------------------------------------------------\n";
            }
        }
        return info;
    }
    private static void calc() { //calculate employees' salaries
        if (checkEmployeesNotNull()) {
            for(Employee employee : employees) {
                employee.calcSalary();
            }
        }
    }
    private static void load() { //load information about drafts and employees
        init();
        loadDrafts();
        loadEmployees();
    }
    private static void write() { //write information about employees' salaries
        writeResults();
    }
    private static void init() { //initialization arrayLists of drafts and employees
        drafts = new ArrayList<Draft>();
        employees = new ArrayList<Employee>();
    }
    private static void loadDrafts() { //load information about drafts from file "Drafts.txt"
        try {
            FileReader fr = new FileReader("src/main/java/Drafts.txt");
            Scanner scan = new Scanner(fr);
            while(scan.hasNextLine()) {
                String strVal = scan.nextLine();
                Pattern p = Pattern.compile("^\'([A-Za-z0-9]+)\'\t+\'([0-9]+[.]?[0-9]+)\'.*$");
                Matcher m = p.matcher(strVal);
                if (m.matches()) {
                    String title = m.group(1).toUpperCase();
                    double budget = Double.parseDouble(m.group(2));
                    newDraft(title, budget);
                }
            }
            scan.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    private static void loadEmployees() { //load information about employees from file "Employees.txt"
        try {
            FileReader fr = new FileReader("src/main/java/Employees.txt");
            Scanner scan = new Scanner(fr);
            while(scan.hasNextLine()) {
                String strVal = scan.nextLine();
                Pattern p = Pattern.compile("^\'([0-9]+)\'\t+\'([A-Za-z]+\\s+[A-Za-z]+\\s+[A-Za-z]+)\'\t+\'([A-Za-z]+)\'\t+\'([0-9]+[.]?[0-9]+)\'\t+\'([A-Za-z0-9]+)\'.*$");
                Matcher m = p.matcher(strVal);
                if (m.matches()) {
                    int id = Integer.parseInt(m.group(1));
                    String fName = m.group(2).toUpperCase();
                    String position = m.group(3).toUpperCase();
                    double workTime = Double.parseDouble(m.group(4));
                    String project = m.group(5).toUpperCase();
                    newEmployee(id, fName, position, workTime, project);
                }
            }
            scan.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeResults() { //write information about employees' salaries to file "Results.txt"
        try {
            FileWriter wr = new FileWriter("src/main/java/Results.txt");
            String[] strArr = getInfo().split("\n");
            for(String strVal : strArr) {
                wr.write(strVal);
                wr.write(System.lineSeparator());
            }
            wr.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    private static boolean newDraft(String title, double budget) { //create and add new draft to ArrayList drafts
        if (checkDraftData(title, budget)) {
            if (!checkDraftByTitle(title)) {
                drafts.add(new Draft(title, budget));
                return true;
            }
        }
        return false;
    }
    private static boolean newEmployee(int id, String fName, String position, double workTime, String project) { //create and add new employee to ArrayList employees
        if (checkEmployeeData(id, fName, position, workTime, project) && checkNoEmployeeId(id)) {
            switch(project) {
                case "NULL":
                    switch(position) {
                        case "CLEANER":
                            Employee cleaner = new Cleaner();
                            cleaner.setData(id, fName, position, workTime, project);
                            employees.add(cleaner);
                            return true;
                        case "DRIVER":
                            Employee driver = new Driver();
                            driver.setData(id, fName, position, workTime, project);
                            employees.add(driver);
                            return true;
                        default:
                            return false;
                    }
                case "ALL":
                    switch(position) {
                        case "SENIORMANAGER":
                            if (checkNoSeniorManager()) {
                                Employee seniorManager = new SeniorManager();
                                seniorManager.setData(id, fName, position, workTime, project);
                                employees.add(seniorManager);
                                if (checkDraftsNotNull()) {
                                    for (Draft draft : drafts) {
                                        draft.addIdEmployee(id);
                                    }
                                    return true;
                                }
                            }
                        default:
                            return false;
                    }
                default:
                    Draft proj = getDraftByTitle(project);
                    if (notNull(proj) && checkNoEmployeeOfProjects(id)) {
                        switch (position) {
                            case "PROGRAMMER":
                                Employee programmer = new Programmer();
                                programmer.setData(id, fName, position, workTime, project);
                                employees.add(programmer);
                                proj.addIdEmployee(id);
                                return true;
                            case "TESTER":
                                Employee tester = new Tester();
                                tester.setData(id, fName, position, workTime, project);
                                employees.add(tester);
                                proj.addIdEmployee(id);
                                return true;
                            case "TEAMLEADER":
                                Employee teamLeader = new TeamLeader();
                                teamLeader.setData(id, fName, position, workTime, project);
                                employees.add(teamLeader);
                                proj.addIdEmployee(id);
                                return true;
                            case "MANAGER":
                                Employee manager = new Manager();
                                manager.setData(id, fName, position, workTime, project);
                                employees.add(manager);
                                proj.addIdEmployee(id);
                                return true;
                            case "PROJECTMANAGER":
                                if (checkNoProjectManager(proj)) {
                                    Employee projectManager = new ProjectManager();
                                    projectManager.setData(id, fName, position, workTime, project);
                                    employees.add(projectManager);
                                    proj.addIdEmployee(id);
                                    proj.setIdProjManager(id);
                                    return true;
                                }
                            default:
                                return false;
                        }
                    }
            }
        }
        return false;
    }
    public static int getEmployeesCountOfAllProjects() { //get employees' count of all projects
        int count = 0;
        if (checkDraftsNotNull()) {
            for(Draft draft : drafts) {
                count += draft.getEmployeesCount();
            }
        }
        return count;
    }
    public static int getEmployeesCountOfProjectByTitle(String title) { //get employees' count of project by project's title
        int count = 0;
        Draft draft = getDraftByTitle(title);
        if (notNull(draft)) {
            count = draft.getEmployeesCount();
        }
        return count;
    }
    public static int getProgrammersCountOfProject(String title) { //get programmers' count of project
        int programmersCount = 0;
        Draft draft = getDraftByTitle(title);
        if (notNull(draft)) {
            ArrayList<Integer> idEmployees = draft.getIdEmployees();
            if (notNull(idEmployees)) {
                for(int idVal : idEmployees) {
                    if (getEmployeeById(idVal).getPosition().equals("PROGRAMMER")) {
                        programmersCount++;
                    }
                }
            }
        }
        return programmersCount;
    }
    public static double getSeniorRate() { //get seniorManager's rate for calculate salary
        double seniorRate = 0;
        if (checkDraftsNotNull()) {
            for(Draft draft : drafts) {
                double projectRate = 0;
                ArrayList<Integer> idEmployees = draft.getIdEmployees();
                if (notNull(idEmployees)) {
                    double draftWorkTime = 0;
                    for(int idVal : idEmployees) {
                        draftWorkTime += getEmployeeById(idVal).getWorkTime();
                    }
                    if (draftWorkTime != 0) {
                        projectRate = draft.getBudget() / draftWorkTime;
                    }
                }
                seniorRate += projectRate;
            }
        }
        return seniorRate;
    }
    public static double getProjectRate(String title) { //get project's engineer or manager rate for calculate salary
        double projectRate = 0;
        Draft draft = getDraftByTitle(title);
        if (notNull(draft)) {
            ArrayList<Integer> idEmployees = draft.getIdEmployees();
            if (notNull(idEmployees)) {
                double sumWorkTime = 0;
                for(int idVal : idEmployees) {
                    sumWorkTime += getEmployeeById(idVal).getWorkTime();
                }
                if (sumWorkTime != 0) {
                    projectRate = draft.getBudget() / sumWorkTime;
                }
            }
        }
        return projectRate;
    }
    private static double getProjectBudget(String title) { //get project's budget
        double result = 0;
        Draft draft = getDraftByTitle(title);
        if (notNull(draft)) {
            result = draft.getBudget();
        }
        return result;
    }
    private static double getAllProjectsBudget() { //get all projects' budget
        double allBudget = 0;
        if (checkDraftsNotNull()) {
            for(Draft draft : drafts) {
                allBudget += draft.getBudget();
            }
        }
        return allBudget;
    }
    private static int getAllProjectsCount() { //get all projects' count
        int count = 0;
        if (checkDraftsNotNull()) {
            count = drafts.size();
        }
        return count;
    }
    private static double getAllWorkTime() { //get all projects' employees' workTime
        double allWorkTime = 0;
        if (checkEmployeesNotNull()) {
            for(Employee employee : employees) {
                allWorkTime += employee.getWorkTime();
            }
        }
        return allWorkTime;
    }
    private static double getWorkTimeProject(String title) { //get project's all employees' workTime
        double sumWorkTime = 0;
        Draft draft = getDraftByTitle(title);
        if (notNull(draft)) {
            ArrayList<Integer> idEmployees = draft.getIdEmployees();
            if (notNull(idEmployees)) {
                for(int idVal : idEmployees) {
                    sumWorkTime += getEmployeeById(idVal).getWorkTime();
                }
            }
        }
        return sumWorkTime;
    }

    private static Employee getEmployeeById(int id) { //get employee by id
        Employee result = null;
        if (checkEmployeesNotNull()) {
            for(Employee employee : employees) {
                if (id == employee.getId()) {
                    return employee;
                }
            }
        }
        return result;
    }
    private static Draft getDraftByTitle(String title) { //get draft from arrayList "drafts" by draft's title
        if (checkDraftByTitle(title)) {
            for(Draft draft : drafts) {
                if (draft.getTitle().equals(title)) {
                    return draft;
                }
            }
        }
        return null;
    }
    private static boolean checkDraftByTitle(String title) { //check draft in arrayList "drafts" by draft's title
        if (!notNullAndNotEmpty(title)) {
            return false;
        }
        if (checkDraftsNotNull()) {
            for(Draft draft : drafts) {
                if (draft.getTitle().equals(title)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean checkNoSeniorManager() { //check senior manager is the only one
        if (checkEmployeesNotNull()) {
            for(Employee employee : employees) {
                if (employee.getPosition().equals("SENIORMANAGER")) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean checkNoProjectManager(Draft draft) { //check projectManager of project
        if (notNull(draft)) {
            if (draft.getIdProjManager() != 0) {
                return false;
            }
        }
        return true;
    }
    private static boolean checkNoEmployeeOfProjects(int id) { //check employee work with only one project
        if (checkDraftsNotNull()) {
            for(Draft draft : drafts) {
                if (draft.checkIdEmployee(id)) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean checkNoEmployeeId(int id) { //check employee's id in arrayList "employees"
        if (checkEmployeesNotNull()) {
            for(Employee employee : employees) {
                if (id == employee.getId()) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean checkDraftData(String title, double budget) { //check draft's data
        boolean checkData;
        checkData = notNullAndNotEmpty(title);
        checkData &= (budget > 0);
        return checkData;
    }
    private static boolean checkEmployeeData(int id, String fName, String position, double workTime, String project) { //check employee's data
        boolean checkData;
        checkData = (id > 0);
        checkData &= notNullAndNotEmpty(fName);
        checkData &= notNullAndNotEmpty(position);
        checkData &= (workTime >= 0);
        checkData &= notNullAndNotEmpty(project);
        return checkData;
    }
    private static boolean checkDraftsNotNull() { //check drafts is not null
        return (drafts != null);
    }
    private static boolean checkEmployeesNotNull() { //check employees is not null
        return (employees != null);
    }
    private static boolean notNull(Draft draft) { //check draft is not null
        return (draft != null);
    }
    private static boolean notNull(Employee employee) { //check employee is not null
        return (employee != null);
    }
    private static boolean notNull(ArrayList<Integer> idEmployees) { //check idEmployees is not null
        return (idEmployees != null);
    }
    private static boolean notNullAndNotEmpty(String string) { //check string is not null and not empty ""
        return (string != null && !string.equals(""));
    }
    /*
    class for testing private static methods from class HR
    */
    public static class Test
    {
        public static void calc() {
            HR.calc();
        }
        public static void load() {
            HR.load();
        }
        public static void write() {
            HR.write();
        }
        public static void init() {
            HR.init();
        }
        public static void loadDrafts() {
            HR.loadDrafts();
        }
        public static void loadEmployees() {
            HR.loadEmployees();
        }
        public static void writeResults() {
            HR.writeResults();
        }
        public static boolean newDraft(String title, double budget) {
            return HR.newDraft(title, budget);
        }
        public static boolean newEmployee(int id, String fName, String position, double workTime, String project) {
            return HR.newEmployee(id, fName, position, workTime, project);
        }
        public static double getProjectBudget(String title) {
            return HR.getProjectBudget(title);
        }
        public static double getAllProjectsBudget() {
            return HR.getAllProjectsBudget();
        }
        public static int getAllProjectsCount() {
            return HR.getAllProjectsCount();
        }
        public static double getAllWorkTime() {
            return HR.getAllWorkTime();
        }
        public static double getWorkTimeProject(String title) {
            return HR.getWorkTimeProject(title);
        }
        public static Employee getEmployeeById(int id) {
            return HR.getEmployeeById(id);
        }
        public static Draft getDraftByTitle(String title) {
            return HR.getDraftByTitle(title);
        }
        public static boolean checkDraftByTitle(String title) {
            return HR.checkDraftByTitle(title);
        }
        public static boolean checkNoSeniorManager() {
            return HR.checkNoSeniorManager();
        }
        public static boolean checkNoProjectManager(Draft draft) {
            return HR.checkNoProjectManager(draft);
        }
        public static boolean checkNoEmployeeOfProjects(int id) {
            return HR.checkNoEmployeeOfProjects(id);
        }
        public static boolean checkNoEmployeeId(int id) {
            return HR.checkNoEmployeeId(id);
        }
        public static boolean checkDraftData(String title, double budget) {
            return HR.checkDraftData(title, budget);
        }
        public static boolean checkEmployeeData(int id, String fName, String position, double workTime, String project) {
            return HR.checkEmployeeData(id, fName, position, workTime, project);
        }
        public static boolean checkDraftsNotNull() {
            return HR.checkDraftsNotNull();
        }
        public static boolean checkEmployeesNotNull() {
            return HR.checkEmployeesNotNull();
        }
        public static boolean notNullDraft(Draft draft) {
            return HR.notNull(draft);
        }
        public static boolean notNullEmployee(Employee employee) {
            return HR.notNull(employee);
        }
        public static boolean notNullIdEmployees(ArrayList<Integer> idEmployees) {
            return HR.notNull(idEmployees);
        }
        public static boolean notNullAndNotEmptyString(String string) {
            return HR.notNullAndNotEmpty(string);
        }
    }
}
