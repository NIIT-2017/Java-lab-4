import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Staff {
    private int id, base, budget, duration, subordinates, rate;
    private double share;
    private String name, position;
    private ArrayList<Employee> employees = new ArrayList<>();

    public void makeStaff(String fileName){
        Employee employee = null;
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray staff = (JSONArray) jsonObject.get("employees");
            for(int i = 0 ; i< staff.size() ;i++){
                JSONObject object = (JSONObject) staff.get(i);
                id = Integer.parseInt((String)object.get("id"));
                name = (String) object.get("name");
                position = (String) object.get("position");
                switch (position) {
                    case "cleaner" : base = Integer.parseInt((String) object.get("base"));
                        employee = new Cleaner.Builder().
                                base(base).
                                worktime(setRandomTime()).
                                newEmployee(id, name, position).build();
                        employees.add(employee);
                        break;
                    case "driver" : base = Integer.parseInt((String) object.get("base"));
                        employee = new Driver.Builder().
                                extraCharge(2000).
                                worktime(setRandomTime()).
                                base(base).
                                newEmployee(id, name, position).build();
                        employees.add(employee);
                        break;
                    case "programmer":
                    case "tester" :
                        base = Integer.parseInt((String) object.get("base"));
                        budget = Integer.parseInt((String) object.get("budget"));
                        duration = Integer.parseInt((String) object.get("duration"));
                        share = Double.parseDouble((String) object.get("share"));
                        employee = new Programmer.Builder().
                                base(base).
                                budget(budget).
                                duration(duration).
                                share(share).
                                worktime(setRandomTime()).
                                newEmployee(id, name, position).build();
                        employees.add(employee);
                        break;
                    case "team-leader" : base = Integer.parseInt((String) object.get("base"));
                        budget = Integer.parseInt((String) object.get("budget"));
                        duration = Integer.parseInt((String) object.get("duration"));
                        share = Double.parseDouble((String) object.get("share"));
                        subordinates = Integer.parseInt((String) object.get("subordinates"));
                        rate = Integer.parseInt((String) object.get("rate"));
                        employee = new TeamLeader.Builder().
                                rate(rate).
                                subordinates(subordinates).
                                base(base).
                                budget(budget).
                                share(share).
                                duration(duration).
                                worktime(setRandomTime()).
                                newEmployee(id, name, position).build();
                        employees.add(employee);
                        break;
                    case "manager" : budget = Integer.parseInt((String) object.get("budget"));
                        duration = Integer.parseInt((String) object.get("duration"));
                        share = Double.parseDouble((String) object.get("share"));
                        employee = new Manager.Builder().
                                budget(budget).
                                duration(duration).
                                share(share).
                                newEmployee(id, name, position).build();
                        employees.add(employee);
                        break;
                    case "projectManager" : budget = Integer.parseInt((String) object.get("budget"));
                        duration = Integer.parseInt((String) object.get("duration"));
                        share = Double.parseDouble((String) object.get("share"));
                        subordinates = Integer.parseInt((String) object.get("subordinates"));
                        rate = Integer.parseInt((String) object.get("rate"));
                        employee = new ProjectManager.Builder().
                                subordinates(subordinates).
                                rate(rate).
                                budget(budget).
                                duration(duration).
                                share(share).
                                newEmployee(id, name, position).build();
                        employees.add(employee);
                        break;
                    case "seniorManager" : budget = Integer.parseInt((String) object.get("budget"));
                        duration = Integer.parseInt((String) object.get("duration"));
                        share = Double.parseDouble((String) object.get("share"));
                        subordinates = Integer.parseInt((String) object.get("subordinates"));
                        rate = Integer.parseInt((String) object.get("rate"));
                        employee = new SeniorManager.Builder().
                                subordinates(subordinates).
                                rate(rate).budget(budget).
                                duration(duration).
                                share(share).
                                newEmployee(id, name, position).build();
                        employees.add(employee);
                        break;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public void printData(){
        for(Employee employee : employees){
            employee.countPayment();
            System.out.println("id: " + employee.getId() + " name: " + employee.getName() + " position: " + employee.getPosition() );
            System.out.format("payment: %,d\n", employee.getPayment());
        }
    }
    public int setRandomTime(){
        Random random = new Random();
        int worktime = 40 + random.nextInt(160-40 + 1);
        return worktime;
    };
}
