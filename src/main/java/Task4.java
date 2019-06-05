import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Task4 {
    public static void main(String[] args){
        ArrayList<Employee> staff = new ArrayList<Employee>();
        int id = 0;
        JSONParser parser = new JSONParser();
        try{
            Object obj=parser.parse(new FileReader("staff.json"));
            JSONObject j = (JSONObject) obj;
            JSONArray stff=(JSONArray)j.get("stuff");
            Iterator employeeItr=stff.iterator();
            while(employeeItr.hasNext()){
                JSONObject str=(JSONObject)employeeItr.next();
                if (str.get("position").toString().equalsIgnoreCase("Cleaner")){
                    String name = str.get("name").toString();
                    String position = str.get("position").toString();
                    int base = Integer.parseInt(str.get("base").toString());
                    staff.add(new Cleaner(++id, name, position, base));
                }
                if (str.get("position").toString().equalsIgnoreCase("Driver")){
                    String name = str.get("name").toString();
                    String position = str.get("position").toString();
                    int base = Integer.parseInt(str.get("base").toString());
                    staff.add(new Driver(++id, name, position, base));
                }
                if (str.get("position").toString().equalsIgnoreCase("Programmer")){
                    String name = str.get("name").toString();
                    String position = str.get("position").toString();
                    int base = Integer.parseInt(str.get("base").toString());
                    int project = Integer.parseInt(str.get("project").toString());
                    double part = Double.parseDouble((str.get("part").toString()));
                    staff.add(new Programmer(++id, name, position, base, project, part));
                }
                if (str.get("position").toString().equalsIgnoreCase("Tester")){
                    String name = str.get("name").toString();
                    String position = str.get("position").toString();
                    int base = Integer.parseInt(str.get("base").toString());
                    int project = Integer.parseInt(str.get("project").toString());
                    double part = Double.parseDouble((str.get("part").toString()));
                    staff.add(new Tester(++id, name, position, base, project, part));
                }
                if (str.get("position").toString().equalsIgnoreCase("TeamLeader")){
                    String name = str.get("name").toString();
                    String position = str.get("position").toString();
                    int base = Integer.parseInt(str.get("base").toString());
                    int project = Integer.parseInt(str.get("project").toString());
                    int numofsubord = Integer.parseInt(str.get("numofsubord").toString());
                    double part = Double.parseDouble((str.get("part").toString()));
                    staff.add(new TeamLeader(++id, name, position, base, project, part, numofsubord));
                }
                if (str.get("position").toString().equalsIgnoreCase("ProjectManager")){
                    String name = str.get("name").toString();
                    String position = str.get("position").toString();
                    int base = Integer.parseInt(str.get("base").toString());
                    int project = Integer.parseInt(str.get("project").toString());
                    int numofsubord = Integer.parseInt(str.get("numofsubord").toString());
                    double part = Double.parseDouble((str.get("part").toString()));
                    staff.add(new ProjectManager(++id, name, position, base, project, numofsubord, part));
                }
                if (str.get("position").toString().equalsIgnoreCase("SeniorManager")){
                    String name = str.get("name").toString();
                    String position = str.get("position").toString();
                    int base = Integer.parseInt(str.get("base").toString());
                    int project = Integer.parseInt(str.get("project").toString());
                    int numofsubord = Integer.parseInt(str.get("numofsubord").toString());
                    double part = Double.parseDouble((str.get("part").toString()));
                    staff.add(new ProjectManager(++id, name, position, base, project, numofsubord, part));
                }
            }
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

        for (Employee st: staff){
            st.setWorktime(40);
            st.calc();
            System.out.println("id: " + st.getId() );
            System.out.println("name: " + st.getName());
            System.out.println("position: " + st.getPosition());
            System.out.println("Payment: " + st.getPayment());
        }


    }

}
