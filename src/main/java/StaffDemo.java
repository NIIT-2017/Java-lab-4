import java.util.ArrayList;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class StaffDemo {
    private static ArrayList<Employee> staff;

    public static void main(String[] args) {
        createStaffFromFile();
        calcPayments();
        printInfo();
    }

    private static void calcPayments() {
        for (Employee item:staff) {
            item.calculatePayment();
        }
    }

    private static void printSpace(int amount){
        for (int i = 0; i < amount; i++) {
            System.out.print(" ");
        }
    }

    private static void printInfo(){
        int sizeMazFio = 0;
        int sizeMaxPayment = 0;

        for (Employee item:staff) {
            int sizeFioTemp = item.fio.length();
            if (sizeFioTemp > sizeMazFio)
                sizeMazFio = sizeFioTemp;

            int sizePaymentTemp = Double.toString(item.payment).length();
            if (sizePaymentTemp > sizeMaxPayment)
                sizeMaxPayment = sizePaymentTemp;
        }
        System.out.println((char)27 + "[01;31m");
        System.out.print("Id:  FIO:");
        printSpace(sizeMazFio - 1);
        System.out.println("Position:     Work time:  Project:    Payment:");
        System.out.println((char)27 + "[38m");

        for (Employee item:staff) {
            int sizeId = Integer.toString(item.id).length();
            System.out.print(item.id);
            printSpace(2 - sizeId + 3);

            int sizeItemFio = item.fio.length();
            System.out.print(item.fio);
            printSpace(sizeMazFio - sizeItemFio + 3);

            int sizePosition = item.position.length();
            System.out.print(item.position);
            printSpace(14 - sizePosition + 3);

            int sizeWorkTime = Integer.toString(item.workTime).length();
            System.out.print(item.workTime);
            printSpace(3 - sizeWorkTime + 6);

            if (item.position.compareTo("Cleaner") == 0 || item.position.compareTo("Driver") == 0){
                System.out.print("    -    ");
                printSpace(3);
            }else if(item.position.compareTo("SeniorManager") == 0){
                Project temp = (Project)item;
                System.out.print(temp.getProject());
                printSpace(6 + 3);
            }else {
                Project temp = (Project)item;
                System.out.print(temp.getProject());
                printSpace(3);
            }

            int sizeItemPayment = Double.toString(item.payment).length();
            System.out.print(item.payment);
            printSpace(sizeMaxPayment - sizeItemPayment + 3);

            System.out.println();
        }
    }

    private static void createStaffFromFile(){
        staff = new ArrayList<>();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("staff.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            JSONParser parser=new JSONParser();
            JSONObject js=(JSONObject)parser.parse(reader);
            JSONArray items=(JSONArray)js.get("staff");

            for(Object i : items) {
                int id = Math.toIntExact((Long) ((JSONObject)i).get("id"));
                String fio = (String) ((JSONObject)i).get("fio");
                String position = (String) ((JSONObject)i).get("position");

                if (position.compareTo("Cleaner") == 0 || position.compareTo("Driver") == 0){

                    int workTime = Math.toIntExact((Long) ((JSONObject)i).get("workTime"));
                    int base = Math.toIntExact((Long) ((JSONObject)i).get("base"));

                    switch (position){
                        case "Cleaner" : staff.add(new Cleaner(id, fio, workTime, position, base)); break;
                        case "Driver" : staff.add(new Driver(id, fio, workTime, position, base)); break;
                    }
                }else if (position.compareTo("Programmer") == 0 || position.compareTo("Tester") == 0
                        || position.compareTo("TeamLeader") == 0){

                    int workTime = Math.toIntExact((Long) ((JSONObject) i).get("workTime"));
                    int base = Math.toIntExact((Long) ((JSONObject) i).get("base"));
                    String project = (String) ((JSONObject) i).get("project");
                    int projectPercent = Math.toIntExact((Long) ((JSONObject) i).get("projectPercent"));
                    double projectBase = Math.toIntExact((Long)  ((JSONObject) i).get("projectBase"));

                    switch (position){
                        case "Programmer" : staff.add(new Programmer(id, fio, workTime, position, base,
                                project, projectBase, projectPercent)); break;

                        case "Tester" : staff.add(new Tester(id, fio, workTime, position, base,
                                project, projectBase, projectPercent)); break;

                        case "TeamLeader" : {
                            int subordinates = Math.toIntExact((Long)((JSONObject) i).get("subordinates"));
                            staff.add(new TeamLeader(id, fio, workTime, position, base,
                                    project, projectBase, projectPercent, subordinates));
                        } break;
                    }
                }else if (position.compareTo("Manager") == 0){

                    int workTime = Math.toIntExact((Long)((JSONObject) i).get("workTime"));
                    String project = (String) ((JSONObject) i).get("project");
                    int projectPercent = Math.toIntExact((Long)((JSONObject) i).get("projectPercent"));
                    double projectBase = Math.toIntExact((Long) ((JSONObject) i).get("projectBase"));
                    staff.add(new Manager(id, fio, workTime, position, project, projectBase, projectPercent));
                }else{

                    int workTime = Math.toIntExact((Long)((JSONObject) i).get("workTime"));
                    String project = (String) ((JSONObject) i).get("project");
                    int projectPercent = Math.toIntExact((Long)((JSONObject) i).get("projectPercent"));
                    double projectBase = Math.toIntExact((Long) ((JSONObject) i).get("projectBase"));
                    int subordinates = Math.toIntExact((Long)((JSONObject) i).get("subordinates"));

                    switch (position) {
                        case "ProjectManager":
                            staff.add(new ProjectManager(id, fio, workTime, position, project,
                                    projectBase, projectPercent, subordinates));
                            break;

                        case "SeniorManager":
                            staff.add(new SeniorManager(id, fio, workTime, position, project,
                                    projectBase, projectPercent, subordinates));
                            break;
                    }
                }
            }
        }catch (Exception e){
            System.out.print("Error create staff from file: ");
            System.out.println(e);
        }
    }
}
