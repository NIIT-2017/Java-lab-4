import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        ArrayList<Programmer> programmers = new ArrayList<>();
        ArrayList<Tester> testers = new ArrayList<>();
        ArrayList<TeamLeader> teamLeaders = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<ProjectManager> projectManagers = new ArrayList<>();
        ArrayList<SeniorManager> seniorManagers = new ArrayList<>();
        ArrayList<Cleaner> cleaners = new ArrayList<>();
        ArrayList<Driver> drivers = new ArrayList<>();

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/main/resources/Staff.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray staffList = (JSONArray) jsonObject.get("staff");

            for (Object o : staffList) {
                Long id = (Long) ((JSONObject) o).get("id");
                String name = (String) ((JSONObject) o).get("name");
                String position = (String) ((JSONObject) o).get("position");
                Double base = (Double) ((JSONObject) o).get("base");
                String project = (String) ((JSONObject) o).get("project");
                Long workTime = (Long) ((JSONObject) o).get("workTime");

                if (position.contains("manager")) {
                    Manager manager = GSON.fromJson(String.valueOf(jsonObject), Manager.class);
                    managers.add(manager);
                    manager.setId(id);
                    manager.setName(name);
                    manager.setProjectName(project);

                } else if (position.contains("programmer")) {
                    Programmer programmer = GSON.fromJson(String.valueOf(jsonObject), Programmer.class);
                    programmers.add(programmer);
                    programmer.setId(id);
                    programmer.setName(name);
                    programmer.setWorkTime(workTime);
                    programmer.setBase(base);
                    programmer.setProjectName(project);

                } else if (position.contains("tester")) {
                    Tester tester = GSON.fromJson(String.valueOf(jsonObject), Tester.class);
                    testers.add(tester);
                    tester.setId(id);
                    tester.setName(name);
                    tester.setWorkTime(workTime);
                    tester.setBase(base);
                    tester.setProjectName(project);


                } else if (position.contains("projectManager")) {
                    ProjectManager projectManager = GSON.fromJson(String.valueOf(jsonObject), ProjectManager.class);
                    projectManagers.add(projectManager);
                    projectManager.setId(id);
                    projectManager.setName(name);
                    projectManager.setProjectName(project);

                } else if (position.contains("seniorManager")) {
                    SeniorManager seniorManager = GSON.fromJson(String.valueOf(jsonObject), SeniorManager.class);
                    seniorManagers.add(seniorManager);
                    seniorManager.setId(id);
                    seniorManager.setName(name);
                    seniorManager.setProjectName(project);
                } else if (position.contains("teamLead")) {
                    TeamLeader teamLeader = GSON.fromJson(String.valueOf(jsonObject), TeamLeader.class);
                    teamLeaders.add(teamLeader);
                    teamLeader.setId(id);
                    teamLeader.setName(name);
                    teamLeader.setWorkTime(workTime);
                    teamLeader.setBase(base);
                    teamLeader.setProjectName(project);
                } else if (position.contains("cleaner")) {
                    Cleaner cleaner = GSON.fromJson(String.valueOf(jsonObject), Cleaner.class);
                    cleaners.add(cleaner);
                    cleaner.setId(id);
                    cleaner.setName(name);
                    cleaner.setWorkTime(workTime);
                    cleaner.setBase(base);
                } else if (position.contains("driver")) {
                    Driver driver = GSON.fromJson(String.valueOf(jsonObject), Driver.class);
                    drivers.add(driver);
                    driver.setId(id);
                    driver.setName(name);
                    driver.setWorkTime(workTime);
                    driver.setBase(base);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println("Salary calculation:");
        System.out.println("\n--------Senior-Manager--------");
        for (SeniorManager sm:seniorManagers) {
            sm.setPayForOneSub(5000);
            sm.setSubStaff(5);
            sm.setPercentOfParticipate(1);
            sm.setSumOfProject(Project.budgetOfProject1 +Project.budgetOfProject2 +Project.budgetOfProject3);
            System.out.println(sm.getName()+"\t"+sm.calcPayment());
        }
        System.out.println("\n--------Project-Managers--------");

        for (ProjectManager pm : projectManagers) {
            pm.setPayForOneSub(4000);
            pm.setSubStaff(4);

            if (pm.getProjectName().contains("CIA")) {//TODO unhardcode projects
                pm.setPercentOfParticipate(2);
                pm.setSumOfProject(Project.budgetOfProject1);
            } else if (pm.getProjectName().contains("FBI")) {
                pm.setPercentOfParticipate(2);
                pm.setSumOfProject(Project.budgetOfProject2);
            } else if (pm.getProjectName().contains("MI8")) {
                pm.setPercentOfParticipate(2);
                pm.setSumOfProject(Project.budgetOfProject3);

            }
            System.out.println(pm.getName()+"\t"+pm.calcPayment());
        }

        System.out.println("\n--------Managers--------");
        for (Manager m : managers) {
            if (m.getProjectName().contains("CIA")) {
                m.setPercentOfParticipate(1);
                m.setSumOfProject(Project.budgetOfProject1);
            } else if (m.getProjectName().contains("FBI")) {
                m.setPercentOfParticipate(1);
                m.setSumOfProject(Project.budgetOfProject2);
            } else if (m.getProjectName().contains("MI8")) {
                m.setPercentOfParticipate(1);
                m.setSumOfProject(Project.budgetOfProject3);
            }
            System.out.println( m.getName()+"\t"+m.calcPayment());
        }

        System.out.println("\n--------Team-Lead--------");
        for (TeamLeader tl:teamLeaders) {
            tl.setNumOfEmpl(5);
            tl.setPayForOneEmpl(5000);

            if (tl.getProjectName().contains("CIA")) {
                tl.setPercentOfParticipate(3);
                tl.setSumOfProject(Project.budgetOfProject1);
            } else if (tl.getProjectName().contains("FBI")) {
                tl.setPercentOfParticipate(2);
                tl.setSumOfProject(Project.budgetOfProject2);
            } else if (tl.getProjectName().contains("MI8")) {
                tl.setPercentOfParticipate(1);
                tl.setSumOfProject(Project.budgetOfProject3);
            }
            System.out.println(tl.getName()+"\t"+tl.calcPayment());
        }


        System.out.println("\n--------Programmers--------");
        for (Programmer pr : programmers) {
            if (pr.getProjectName().contains("CIA")) {
                pr.setPercentOfParticipate(1);
                pr.setSumOfProject(Project.budgetOfProject1);
            } else if (pr.getProjectName().contains("FBI")) {
                pr.setPercentOfParticipate(1);
                pr.setSumOfProject(Project.budgetOfProject2);
            } else if (pr.getProjectName().contains("MI8")) {
                pr.setPercentOfParticipate(1);
                pr.setSumOfProject(Project.budgetOfProject3);
            }

            System.out.println(pr.getName()+"\t"+pr.calcPayment());

        }
        System.out.println("\n--------Testers--------");

        for (Tester t : testers) {
            if (t.getProjectName().contains("CIA")) {
                t.setPercentOfParticipate(1);
                t.setSumOfProject(Project.budgetOfProject1);
            } else if (t.getProjectName().contains("FBI")) {
                t.setPercentOfParticipate(1);
                t.setSumOfProject(Project.budgetOfProject1);
            } else if (t.getProjectName().contains("MI8")) {
                t.setPercentOfParticipate(1);
                t.setSumOfProject(Project.budgetOfProject3);
            }

            System.out.println(t.getName() + "\t" + t.calcPayment());
        }


        System.out.println("\n--------Drivers--------");
        drivers.forEach(driver -> System.out.println(driver.getName()+"\t"+driver.calcPayment()));


        System.out.println("\n--------Cleaners--------");
        cleaners.forEach(cl-> System.out.println(cl.getName()+"\t"+cl.calcPayment()));



    }

}