import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Task {
    public static void main(String args[]){
        ArrayList<Employee> employees = new ArrayList<Employee>();
        JSONParser jParser = new JSONParser();

        // import from <filename>.json
        try{
            JSONObject jo = (JSONObject)jParser.parse(new FileReader("stuff.json"));
            JSONArray ja = (JSONArray)jo.get("stuff");
            Iterator iter = ja.iterator();
            int id = 1;
            while (iter.hasNext()){
                JSONObject buf = (JSONObject)iter.next();
                if (buf.get("position").toString().equalsIgnoreCase("Cleaner")){
                    String name = buf.get("name").toString();
                    String position = buf.get("position").toString();
                    int base = Integer.parseInt(buf.get("base").toString());
                    Cleaner temp = new Cleaner(id, name, position, base);
                    employees.add(temp);
                }
                else if (buf.get("position").toString().equalsIgnoreCase("Driver")){
                    String name = buf.get("name").toString();
                    String position = buf.get("position").toString();
                    int base = Integer.parseInt(buf.get("base").toString());
                    Driver temp = new Driver(id, name, position, base);
                    employees.add(temp);
                }
                else if (buf.get("position").toString().equalsIgnoreCase("Programmer")){
                    String name = buf.get("name").toString();
                    String position = buf.get("position").toString();
                    int base = Integer.parseInt(buf.get("base").toString());
                    int project = Integer.parseInt(buf.get("project").toString());
                    double part = Double.parseDouble(buf.get("part").toString());
                    Programmer temp = new Programmer(id, name, position, base, project, part);
                    employees.add(temp);
                }
                else if (buf.get("position").toString().equalsIgnoreCase("Tester")){
                    String name = buf.get("name").toString();
                    String position = buf.get("position").toString();
                    int base = Integer.parseInt(buf.get("base").toString());
                    int project = Integer.parseInt(buf.get("project").toString());
                    double part = Double.parseDouble(buf.get("part").toString());
                    Tester temp = new Tester(id, name, position, base, project, part);
                    employees.add(temp);
                }
                else if (buf.get("position").toString().equalsIgnoreCase("TeamLeader")){
                    String name = buf.get("name").toString();
                    String position = buf.get("position").toString();
                    int base = Integer.parseInt(buf.get("base").toString());
                    int project = Integer.parseInt(buf.get("project").toString());
                    double part = Double.parseDouble(buf.get("part").toString());
                    int subordinateCount = Integer.parseInt(buf.get("subordinateCount").toString());
                    double ratio = Double.parseDouble(buf.get("ratio").toString());
                    TeamLeader temp = new TeamLeader(id, name, position, base, project, part, subordinateCount, ratio);
                    employees.add(temp);
                }
                else if (buf.get("position").toString().equalsIgnoreCase("ProjectManager")){
                    String name = buf.get("name").toString();
                    String position = buf.get("position").toString();
                    int project = Integer.parseInt(buf.get("project").toString());
                    double part = Double.parseDouble(buf.get("part").toString());
                    int subordinateCount = Integer.parseInt(buf.get("subordinateCount").toString());
                    double ratio = Double.parseDouble(buf.get("ratio").toString());
                    ProjectManager temp = new ProjectManager(id, name, position, project, part, subordinateCount, ratio);
                    employees.add(temp);
                }
                else if (buf.get("position").toString().equalsIgnoreCase("SeniorManager")){
                    String name = buf.get("name").toString();
                    String position = buf.get("position").toString();
                    int project = Integer.parseInt(buf.get("project").toString());
                    double part = Double.parseDouble(buf.get("part").toString());
                    int subordinateCount = Integer.parseInt(buf.get("subordinateCount").toString());
                    double ratio = Double.parseDouble(buf.get("ratio").toString());
                    SeniorManager temp = new SeniorManager(id, name, position, project, part, subordinateCount, ratio);
                    employees.add(temp);
                }
                id++;
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
        catch(ParseException e) {
            System.out.println(e.getMessage());
        }

        // export to <filename>.json
        try{
            FileWriter fwriter = new FileWriter("Month Salary.json");
            JSONArray ja = new JSONArray();
            for (Employee empl: employees){
                JSONObject jo2 = new JSONObject();
                jo2.put("id: ", empl.getId() );
                jo2.put("name", empl.getName());
                jo2.put("position: ", empl.getPosition());
                jo2.put("payment: ", empl.getPayment());
                ja.add(jo2);
            }
            fwriter.write(ja.toJSONString());
            fwriter.flush();
            fwriter.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        // console output
        for (Employee empl: employees){
            empl.setWorktime(168);
            empl.calcSalary();
            System.out.println("id: " + empl.getId() );
            System.out.println("name: " + empl.getName());
            System.out.println("position: " + empl.getPosition());
            System.out.println("payment: " + empl.getPayment());
        }
    }
}
