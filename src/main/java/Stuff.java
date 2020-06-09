import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;

class Stuff {

    private ArrayList<Employee> emp = new ArrayList<>();

    public Stuff() {
        try {
            URL resource = getClass().getResource("Employee.json");
            File file = Paths.get(resource.toURI()).toFile();
            String content = FileUtils.readFileToString(file, "utf-8");
            JSONArray employees = new JSONArray(content);
            for (int i = 0; i<employees.length(); i++){
                JSONObject employee = employees.getJSONObject(i);
                if (employee.getString("position").equals("Cleaner"))
                    emp.add(Cleaner.generate(employee.getInt("id"),employee.getString("name"),
                            employee.getInt("worktime"),employee.getInt("base"),"Cleaner"));
                else if(employee.getString("position").equals("Driver"))
                    emp.add(Driver.generate(employee.getInt("id"),employee.getString("name"),
                            employee.getInt("worktime"),employee.getInt("base"),"Driver"));
                else if(employee.getString("position").equals("Programmer"))
                    emp.add(Programmer.generate(employee.getInt("id"),employee.getString("name"),"Programmer",
                            employee.getFloat("base"),employee.getString("progect"),employee.getFloat("share"),employee.getInt("worktime")));
                else if(employee.getString("position").equals("Tester"))
                    emp.add(Tester.generate(employee.getInt("id"),employee.getString("name"),"Tester",
                            employee.getInt("base"),employee.getString("progect"),employee.getFloat("share"),employee.getInt("worktime")));
                else if(employee.getString("position").equals("Manager"))
                    emp.add(Manager.generate(employee.getInt("id"),employee.getString("name"),"Manager",
                            employee.getString("progect"),employee.getFloat("share")));
                else if(employee.getString("position").equals("ProgectManager"))
                    emp.add(ProgectManager.generate(employee.getInt("id"),employee.getString("name"),"ProgectManager",
                            employee.getString("progect"),employee.getFloat("share")));
                else if(employee.getString("position").equals("SeniorManager"))
                    emp.add(SeniorManager.generate(employee.getInt("id"),employee.getString("name"),"SeniorManger",
                            employee.getString("progect"),employee.getFloat("share")));
                else
                    emp.add(TeamLeader.generate(employee.getInt("id"),employee.getString("name"),"TeamLeader",
                            employee.getFloat("base"),employee.getString("progect"),employee.getInt("share"),employee.getInt("worktime"),employee.getInt("people")));
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void calcPayments(){
        for (Employee emp : emp)
            emp.CalcSalary();
    }

    public void outputStuff(PrintStream ps){
        String format1 = "%1$-4s|%2$-32s|%3$-15s|%4$-5s\n";
        ps.format(format1,"ID","NAME","POSITION","PAYMENT");
        for (Employee emp : this.emp) {
            ps.format(format1,emp.getId(),emp.getName(),emp.getPosition(),emp.getPayment());
        }
    }
}
