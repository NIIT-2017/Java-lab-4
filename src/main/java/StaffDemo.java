import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class StaffDemo {
    public static void main(String[] args) {
        ArrayList<Employee> staff;
        staff = importJSON ();
        for(Employee emp : staff) {
            emp.setWorktime(30);
            emp.calc();
            System.out.println(emp.getName() + " - " + emp.getPayment());
        }

        System.out.println("Hello");

    }

    private static ArrayList<Employee> importJSON () {
        ArrayList<Employee> staff = new ArrayList<>();
        JSONParser parser = new JSONParser();
        URL file = System.class.getResource("/Staff");
        try
        {
            Object obj=parser.parse(new FileReader(new File(file.getFile())));
            JSONArray people =(JSONArray)obj;
            Iterator personIterator=people.iterator();
            while(personIterator.hasNext()) {
                JSONObject person=(JSONObject)personIterator.next();
                String position = person.get("position").toString();
                switch (position) {
                    case "Cleaner" : {
                        int id = Integer.parseInt(person.get("id").toString());
                        String name = person.get("name").toString();
                        int base = Integer.parseInt(person.get("base").toString());
                        staff.add (new Cleaner (id, name, base));
                        break;
                    }
                    case "Driver" : {
                        int id = Integer.parseInt(person.get("id").toString());
                        String name = person.get("name").toString();
                        int base = Integer.parseInt(person.get("base").toString());
                        staff.add(new Driver(id, name, base));
                        break;
                    }
                    case "Programmer" : {
                        int id = Integer.parseInt(person.get("id").toString());
                        String name = person.get("name").toString();
                        int base = Integer.parseInt(person.get("base").toString());
                        String pname = person.get("project").toString();
                        staff.add(new Programmer(id, name, base, pname));
                        break;
                    }
                    case "Tester" : {
                        int id = Integer.parseInt(person.get("id").toString());
                        String name = person.get("name").toString();
                        int base = Integer.parseInt(person.get("base").toString());
                        String pname = person.get("project").toString();
                        staff.add(new Programmer(id, name, base, pname));
                        break;
                    }
                    case "TeamLeader" : {
                        int id = Integer.parseInt(person.get("id").toString());
                        String name = person.get("name").toString();
                        int base = Integer.parseInt(person.get("base").toString());
                        String pname = person.get("project").toString();
                        int workers = Integer.parseInt(person.get("workers").toString());
                        staff.add(new TeamLeader(id, name, base, pname, workers));
                        break;
                    }
                    case "Manager" : {
                        int id = Integer.parseInt(person.get("id").toString());
                        String name = person.get("name").toString();
                        String pname = person.get("project").toString();
                        staff.add(new Manager(id, name,pname));
                        break;
                    }
                    case "ProjectManager" : {
                        int id = Integer.parseInt(person.get("id").toString());
                        String name = person.get("name").toString();
                        String pname = person.get("project").toString();
                        int workers = Integer.parseInt(person.get("workers").toString());
                        staff.add(new ProjectManager(id, name, pname, workers));
                        break;
                    }
                    case "SeniorManager" : {
                        int id = Integer.parseInt(person.get("id").toString());
                        String name = person.get("name").toString();
                        String pname = person.get("project").toString();
                        int workers = Integer.parseInt(person.get("workers").toString());
                        staff.add(new SeniorManager(id, name, pname, workers));
                        break;
                    }
                    default :
                        System.out.println("Нет такой позиции");
                        break;
                }
            }
        }
        catch(FileNotFoundException ex){}
        catch(IOException ex) {}
        catch (ParseException ex) {}

        return staff;
    }


}
