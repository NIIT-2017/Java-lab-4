//берем фио из txt файла создаем сотрудников записываем все в json файл
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class createJsonEmployeeLIst {

    private static final String FILENAME = "staff.json";
    private static final String TXTFILENAME = "fio.txt";

    static JSONObject Driver(String i , String fio){
        JSONObject employee = new JSONObject();
        employee.put("position","Driver");
        employee.put("id",i);
        employee.put("fio",fio);
        employee.put("base",100.0);
        return employee;
    }
    static JSONObject Cleaner(String i , String fio){
        JSONObject employee = new JSONObject();
        employee.put("position","Cleaner");
        employee.put("id",i);
        employee.put("fio",fio);
        employee.put("base",50.0);
        return employee;
    }
    static JSONObject Programmer(String i , String fio, String project, double budget, double portion ){
        JSONObject employee = new JSONObject();
        employee.put("position","Programmer");
        employee.put("id",i);
        employee.put("fio",fio);
        employee.put("base",200.0);
        employee.put("project",project);
        employee.put("budget", budget);
        employee.put("portion",portion);
        return employee;
    }
    static JSONObject Tester(String i , String fio, String project, double budget, double portion ){
        JSONObject employee = new JSONObject();
        employee.put("position","Tester");
        employee.put("id",i);
        employee.put("fio",fio);
        employee.put("base",150.0);
        employee.put("project",project);
        employee.put("budget", budget);
        employee.put("portion",portion);
        return employee;
    }
    static JSONObject TeamLeader(String i , String fio, String project, double budget, double portion, long subordinates ){
        JSONObject employee = new JSONObject();
        employee.put("position","TeamLeader");
        employee.put("id",i);
        employee.put("fio",fio);
        employee.put("base",300);
        employee.put("project",project);
        employee.put("budget", budget);
        employee.put("portion",portion);
        employee.put("subordinates",subordinates);
        return employee;
    }
    static JSONObject Manager(String i , String fio, String project, double budget, double portion){
        JSONObject employee = new JSONObject();
        employee.put("position","Manager");
        employee.put("id",i);
        employee.put("fio",fio);
        employee.put("project",project);
        employee.put("budget", budget);
        employee.put("portion",portion);
        return employee;
    }

    static JSONObject ProjectManager(String i , String fio, String project, double budget, double portion, long subordinates ) {
        JSONObject employee = new JSONObject();
        employee.put("position", "ProjectManager");
        employee.put("id", i);
        employee.put("fio", fio);
        employee.put("project", project);
        employee.put("budget", budget);
        employee.put("portion", portion);
        employee.put("subordinates", subordinates);
        return employee;
    }
    static JSONObject SeniorManager(String i , String fio, String project, double budget, double portion, long subordinates ) {
        JSONObject employee = new JSONObject();
        employee.put("position", "SeniorManager");
        employee.put("id", i);
        employee.put("fio", fio);
        employee.put("project", project);
        employee.put("budget", budget);
        employee.put("portion", portion);
        employee.put("subordinates", subordinates);
        return employee;
    }

    public static void main(String args[]) {
        ArrayList<String> fio = new ArrayList<String>();
        try {
            Scanner inputScanner = new Scanner(new File(TXTFILENAME));
            while (inputScanner.hasNext()) { // чтение из  txt файла
                fio.add(inputScanner.nextLine());
            }
            inputScanner.close();
        } catch (IOException e) {
            System.err.println(e.toString());
        }

        try {
            FileWriter writer = new FileWriter(FILENAME);
            JSONArray staff = new JSONArray();
            int i=0;
            staff.add(Driver( String.valueOf(1+i), fio.get(i++)));
            staff.add(Driver( String.valueOf(1+i), fio.get(i++)));
            staff.add(Cleaner( String.valueOf(1+i), fio.get(i++)));
            //команда с проектом
            staff.add(Programmer( String.valueOf(1+i), fio.get(i++), "project_1",100000.0, 0.01));
            staff.add(Programmer( String.valueOf(1+i), fio.get(i++), "project_1",100000.0, 0.01));
            staff.add(Tester( String.valueOf(1+i), fio.get(i++), "project_1",100000.0,  0.01));
            staff.add(Tester( String.valueOf(1+i), fio.get(i++), "project_1",1000000.0,  0.01));
            staff.add(TeamLeader( String.valueOf(1+i), fio.get(i++), "project_1",100000.0, 0.01,4));
            staff.add(Manager( String.valueOf(1+i), fio.get(i++), "project_1",100000.0,  0.05));
            staff.add(ProjectManager( String.valueOf(1+i), fio.get(i++), "project_1",100000.0,  0.1, 6 ));
            staff.add(SeniorManager( String.valueOf(1+i), fio.get(i++), "project_1",100000.0,  0.1, 7 ));

            //команда без проекта
            staff.add(Programmer( String.valueOf(1+i), fio.get(i++), "",100000.0,  0.01));
            staff.add(Programmer( String.valueOf(1+i), fio.get(i++), "",100000.0,  0.01));
            staff.add(Tester( String.valueOf(1+i), fio.get(i++), "",100000.0,  0.01));
            staff.add(TeamLeader( String.valueOf(1+i), fio.get(i++), "",100000.0,  0.01,4));
            staff.add(Manager( String.valueOf(1+i), fio.get(i++), "",100000.0,  0.05));
            staff.add(ProjectManager( String.valueOf(1+i), fio.get(i++), "",100000.0,  0.1, 5 ));
            staff.add(SeniorManager( String.valueOf(1+i), fio.get(i++), "",100000.0,  0.1, 7 ));





            writer.write(staff.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println("EXEPTION" + ex);
        }
    }

}
