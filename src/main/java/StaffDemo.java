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
import java.util.List;

public class StaffDemo {
    private String cleaner = "Уборщик";
    private String driver = "Водитель";
    private String developer = "Программист";
    private String manager = "Менеджер";
    private String project_manager = "Менеджер проекта";
    private String senior_manager= "Сеньор менеджер";
    private String teamLead= "Тимлид";

    static File staffList;

  static {
      String fileName = "list.json";
      ClassLoader classLoader = new StaffDemo().getClass().getClassLoader();
      staffList = new File(classLoader.getResource(fileName).getFile());
  }

    static StaffDemo staffDemo = new StaffDemo();

    static ArrayList<Employee> staff = new ArrayList<Employee>();

    public void addCleaner(int id, String fio) {
        staff.add(new Cleaner(id, fio, 160, 80));
    }

    public void addDriver(int id, String fio) {
        staff.add(new Driver(id, fio, 160, 120));
    }

    public void addDeveloper(int id, String fio) {
        staff.add(new Programmer(id, fio, 160, 200));
    }

    public void addManager(int id, String fio) {
        staff.add(new Manager(id, fio));
    }

    public void addProjectManager(int id, String fio) {
        staff.add(new ProjectManager(id, fio));
    }

    public void addSeniorManager(int id, String fio) {
        staff.add(new SeniorManager(id, fio));
    }

    public void addTeamLead(int id, String fio) {
        staff.add(new TeamLeader(id, fio, 160, 230));
    }


    public void recriutStaff(File filename) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filename));
            JSONArray staffJSON = (JSONArray) obj;
            Iterator staffIterator = staffJSON.iterator();
            while (staffIterator.hasNext()) {
                JSONObject staff = (JSONObject) staffIterator.next();
                String proffession = staff.get("position").toString();
                int id = Integer.parseInt(staff.get("ID").toString());
                String fio = staff.get("name").toString();
                if(proffession.equals(cleaner)) {
                    staffDemo.addCleaner(id, fio);
                } else if(proffession.equals(driver)) {
                    staffDemo.addDriver(id, fio);
                } else if(proffession.equals(developer)) {
                    staffDemo.addDeveloper(id, fio);
                } else if(proffession.equals(manager)) {
                    staffDemo.addManager(id, fio);
                } else if(proffession.equals(project_manager)) {
                    staffDemo.addProjectManager(id, fio);
                } else if(proffession.equals(senior_manager)) {
                    staffDemo.addSeniorManager(id, fio);
                } else if(proffession.equals(teamLead)) {
                    staffDemo.addTeamLead(id, fio);
                }
            }

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (ParseException ex) {
        }
    }

    public void printEmployee(ArrayList<Employee> list){
        for(Employee employee : list) {
            System.out.printf("%-20s%-10s%-10s%n", employee.name, employee.calcPay(), employee.getClass());
        }

    }

    public static void main(String[] args) {
        staffDemo.recriutStaff(staffList);
        staffDemo.printEmployee(staff);
    }

}
