//import jdk.nashorn.internal.parser.JSONParser;
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
import java.util.Comparator;
import java.util.Iterator;


public class StaffDemo {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public static void main(String[] args) throws IOException, ParseException {


        // ArrayList<Employee> employees=new ArrayList<Employee>();//в стафф -все сотрудники
        ArrayList<Programmer> programmers = new ArrayList<Programmer>();
        ArrayList<Tester> testers = new ArrayList<Tester>();
        ArrayList<TeamLeader> teamLeaders = new ArrayList<TeamLeader>();
        ArrayList<Manager> managers = new ArrayList<Manager>();
        ArrayList<ProjectManager> projectManagers = new ArrayList<ProjectManager>();
        ArrayList<SeniorManager> seniorManagers = new ArrayList<SeniorManager>();
        ArrayList<Cleaner> cleaners = new ArrayList<Cleaner>();
        ArrayList<Driver> drivers = new ArrayList<Driver>();

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/main/resources/Stuff.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray stuffList = (JSONArray) jsonObject.get("stuff");

            for (Object o : stuffList) {

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
        System.out.println("--------Team-Lead--------");
        for (TeamLeader tl:teamLeaders) {
            tl.setNumOfEmpl(5);
            tl.setPayForOneEmpl(5000);

            if (tl.getProjectName().contains("Pro1")) {
                tl.setPercentOfParticipate(3);
                tl.setSumOfProject(Project.projectOne);
            } else if (tl.getProjectName().contains("Pro2")) {
                tl.setPercentOfParticipate(2);
                tl.setSumOfProject(Project.projectTwo);
            } else if (tl.getProjectName().contains("Pro3")) {
                tl.setPercentOfParticipate(1);
                tl.setSumOfProject(Project.projectThree);
            }
            System.out.println(tl.getName()+"  "+tl.calcPayment());
        }

        System.out.println("--------Senior-Manager--------");
        for (SeniorManager sm:seniorManagers) {
            sm.setPayForOneSub(5000);
            sm.setSubStuff(5);
            sm.setPercentOfParticipate(1);
            sm.setSumOfProject(Project.projectOne+Project.projectTwo+Project.projectThree);
            System.out.println(sm.getName()+"  "+sm.calcPayment());
        }
        System.out.println("--------Project-Managers--------");

        for (ProjectManager pm : projectManagers) {
            pm.setPayForOneSub(4000);
            pm.setSubStuff(4);

            if (pm.getProjectName().contains("Pro1")) {
                pm.setPercentOfParticipate(2);
                pm.setSumOfProject(Project.projectOne);
            } else if (pm.getProjectName().contains("Pro2")) {
                pm.setPercentOfParticipate(2);
                pm.setSumOfProject(Project.projectTwo);
            } else if (pm.getProjectName().contains("Pro3")) {
                pm.setPercentOfParticipate(2);
                pm.setSumOfProject(Project.projectThree);

            }
            System.out.println(pm.getName()+"  "+pm.calcPayment());
        }
        System.out.println("--------Managers--------");

        for (Manager m : managers) {
            if (m.getProjectName().contains("Pro1")) {
                m.setPercentOfParticipate(1);
                m.setSumOfProject(Project.projectOne);
            } else if (m.getProjectName().contains("Pro2")) {
                m.setPercentOfParticipate(1);
                m.setSumOfProject(Project.projectTwo);
            } else if (m.getProjectName().contains("Pro3")) {
                m.setPercentOfParticipate(1);
                m.setSumOfProject(Project.projectThree);
            }
            System.out.println( m.getName()+"  "+m.calcPayment());
        }


                 System.out.println("--------Programmers--------");

                for (Programmer pr : programmers) {

                    if (pr.getProjectName().contains("Pro1")) {
                        pr.setPercentOfParticipate(1);
                        pr.setSumOfProject(Project.projectOne);
                    } else if (pr.getProjectName().contains("Pro2")) {
                        pr.setPercentOfParticipate(1);
                        pr.setSumOfProject(Project.projectTwo);
                    } else if (pr.getProjectName().contains("Pro3")) {
                        pr.setPercentOfParticipate(1);
                        pr.setSumOfProject(Project.projectThree);
                    }

                    System.out.println(pr.getName()+"  "+pr.calcPayment());

                }
                  System.out.println("--------Testers--------");

                    for (Tester t : testers) {
                        if (t.getProjectName().contains("Pro1")) {
                            t.setPercentOfParticipate(1);
                            t.setSumOfProject(Project.projectOne);
                        } else if (t.getProjectName().contains("Pro2")) {
                            t.setPercentOfParticipate(1);
                            t.setSumOfProject(Project.projectOne);
                        } else if (t.getProjectName().contains("Pro3")) {
                            t.setPercentOfParticipate(1);
                            t.setSumOfProject(Project.projectThree);
                        }

                        System.out.println(t.getName() + "  " + t.calcPayment());
                    }


                       System.out.println("--------Drivers--------");
                       drivers.forEach(driver -> System.out.println(driver.getName()+" "+driver.calcPayment()));


                       System.out.println("--------Cleaners--------");
                       cleaners.forEach(cl-> System.out.println(cl.getName()+" "+cl.calcPayment()));



    }

}

    interface WorkTime {

        double payForHours();

    }

    interface Project {
        int projectOne=10000000;
        int projectTwo=13000000;
        int projectThree=16000000;

        double payForProject();

    }

    interface Heading {
        int payForHeading();

    }




