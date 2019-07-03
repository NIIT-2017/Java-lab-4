import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StaffDemo {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<Employee>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("StaffDemo.json"));
            JSONArray people = (JSONArray) obj;
            Iterator employeeItr = people.iterator();

            while (employeeItr.hasNext()) {
                JSONObject str = (JSONObject) employeeItr.next();
                if (str.get("position").toString().equalsIgnoreCase("Cleaner")) {
                    int id = Integer.parseInt(str.get("id").toString());
                    String name = str.get("name").toString();
                    int base = Integer.parseInt(str.get("base").toString());
                    staff.add(new Cleaner(id, name, base));
                }
                if (str.get("position").toString().equalsIgnoreCase("Driver")) {
                    int id = Integer.parseInt(str.get("id").toString());
                    String name = str.get("name").toString();
                    int base = Integer.parseInt(str.get("base").toString());
                    staff.add(new Driver(id, name, base));
                }
                if (str.get("position").toString().equalsIgnoreCase("Programmer")) {
                    int id = Integer.parseInt(str.get("id").toString());
                    String name = str.get("name").toString();
                    int base = Integer.parseInt(str.get("base").toString());
                    String pname = str.get("project").toString();
                    staff.add(new Programmer(id, name, base, pname));
                }
                if (str.get("position").toString().equalsIgnoreCase("Tester")) {
                    int id = Integer.parseInt(str.get("id").toString());
                    String name = str.get("name").toString();
                    int base = Integer.parseInt(str.get("base").toString());
                    String pname = str.get("project").toString();
                    staff.add(new Tester(id, name, base, pname));
                }
                if (str.get("position").toString().equalsIgnoreCase("TeamLeader")) {
                    int id = Integer.parseInt(str.get("id").toString());
                    String name = str.get("name").toString();
                    int base = Integer.parseInt(str.get("base").toString());
                    String pname = str.get("project").toString();
                    int workers = Integer.parseInt(str.get("workers").toString());
                    staff.add(new TeamLeader(id, name, base, pname, workers));
                }
                if (str.get("position").toString().equalsIgnoreCase("ProjectManager")) {
                    int id = Integer.parseInt(str.get("id").toString());
                    String name = str.get("name").toString();
                    String pname = str.get("project").toString();
                    int workers = Integer.parseInt(str.get("workers").toString());
                    staff.add(new ProjectManager(id, name, pname, workers));
                }
                if (str.get("position").toString().equalsIgnoreCase("SeniorManager")) {
                    int id = Integer.parseInt(str.get("id").toString());
                    String name = str.get("name").toString();
                    String pname = str.get("project").toString();
                    int workers = Integer.parseInt(str.get("workers").toString());
                    staff.add(new ProjectManager(id, name, pname, workers));
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        for (Employee st : staff) {
            st.setWorktime(40);
            st.calc();
            System.out.println("id: " + st.getId());
            System.out.println("name: " + st.getName());
            System.out.println("Payment: " + st.getPayment());
        }
    }
}
