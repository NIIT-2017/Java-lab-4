import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MakeStaff {
    public ArrayList<Employee> employees;

    public MakeStaff(String fileName) {
        makeEmployees(fileName);
    }

    public void makeEmployees(String fileName) {
        employees = new ArrayList<Employee>();

        try {
            JSONParser parser = new JSONParser();
            FileReader fr = new FileReader(new File(fileName));
            JSONObject obj = (JSONObject) parser.parse(fr);
            JSONArray staffArr = (JSONArray) obj.get("staff");
            Iterator staffIterator = staffArr.iterator();
            while (staffIterator.hasNext()) {
                JSONObject emp = (JSONObject) staffIterator.next();
                int id = Integer.parseInt(emp.get("id").toString());
                String name = emp.get("name").toString();
                int worktime = Integer.parseInt(emp.get("worktime").toString());
                String position = emp.get("position").toString();
                if (position.equalsIgnoreCase("Cleaner")) {
                    int rate = Integer.parseInt(emp.get("rate").toString());
                    employees.add(new Cleaner(id, name, position, worktime, rate));
                }
                if (position.equalsIgnoreCase("Driver")) {
                    int rate = Integer.parseInt(emp.get("rate").toString());
                    employees.add(new Driver(id, name, position, worktime, rate));
                }
                if (position.equalsIgnoreCase("Programmer")) {
                    int rate = Integer.parseInt(emp.get("rate").toString());
                    String project = emp.get("project").toString();
                    int budget = Integer.parseInt(emp.get("budget").toString());
                    double part = Double.parseDouble(emp.get("part").toString());
                    employees.add(new Programmer(id, name, position, worktime, rate, project, budget, part));
                }
                if (position.equalsIgnoreCase("Tester")) {
                    int rate = Integer.parseInt(emp.get("rate").toString());
                    String project = emp.get("project").toString();
                    int budget = Integer.parseInt(emp.get("budget").toString());
                    double part = Double.parseDouble(emp.get("part").toString());
                    employees.add(new Tester(id, name, position, worktime, rate, project, budget, part));
                }
                if (position.equalsIgnoreCase("TeamLeader")) {
                    int rate = Integer.parseInt(emp.get("rate").toString());
                    String project = emp.get("project").toString();
                    int budget = Integer.parseInt(emp.get("budget").toString());
                    double part = Double.parseDouble(emp.get("part").toString());
                    int subordinates = Integer.parseInt(emp.get("subordinates").toString());
                    int sumForOne = Integer.parseInt(emp.get("sumForOne").toString());
                    employees.add(new TeamLeader(id, name, position, worktime, rate, project, budget, part, subordinates, sumForOne));
                }
                if (position.equalsIgnoreCase("ProjectManager")) {
                    String project = emp.get("project").toString();
                    int budget = Integer.parseInt(emp.get("budget").toString());
                    double part = Double.parseDouble(emp.get("part").toString());
                    int subordinates = Integer.parseInt(emp.get("subordinates").toString());
                    int sumForOne = Integer.parseInt(emp.get("sumForOne").toString());
                    employees.add(new ProjectManager(id, name, position, worktime, project, budget, part, subordinates, sumForOne));
                }
                if (position.equalsIgnoreCase("SeniorManager")) {
                    String project = emp.get("project").toString();
                    int budget = Integer.parseInt(emp.get("budget").toString());
                    double part = Double.parseDouble(emp.get("part").toString());
                    int subordinates = Integer.parseInt(emp.get("subordinates").toString());
                    int sumForOne = Integer.parseInt(emp.get("sumForOne").toString());
                    employees.add(new SeniorManager(id, name, position, worktime, project, budget, part, subordinates, sumForOne));
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
