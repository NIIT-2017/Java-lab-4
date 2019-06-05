import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadStaff {

    public static ArrayList<Employee> readJsonFile(String fileName) {

        ArrayList<Employee> employees = new ArrayList();

            JSONParser parser = new JSONParser();
            JSONArray staffJA = new JSONArray();
            try {
                FileReader reader = new FileReader(fileName);
                try {
                    staffJA = (JSONArray) parser.parse(reader);
                }
                catch ( ParseException ex){
                    System.err.println(ex.toString());
                }


                for (Object item :staffJA) {
                    JSONObject newEmployeeJO = new JSONObject();
                    newEmployeeJO= (JSONObject) item;
                    String position  =(String) newEmployeeJO.get("position");

                    if ( position.equals("Driver") ){
                        Driver newEmployee = new Driver(
                            (String) newEmployeeJO.get("id"),
                            (String) newEmployeeJO.get("fio"),
                            (Double)  newEmployeeJO.get("base")
                         );
                        employees.add(newEmployee);
                    }

                    if (position.equals("Cleaner") ){
                        Cleaner newEmployee = new Cleaner(
                            (String) newEmployeeJO.get("id"),
                            (String) newEmployeeJO.get("fio"),
                            (Double) newEmployeeJO.get("base")
                        );
                        employees.add(newEmployee);
                    }

                    if (position.equals("Programmer") ){
                        Programmer newEmployee = new Programmer(
                            (String) newEmployeeJO.get("id"),
                            (String) newEmployeeJO.get("fio"),
                            (Double) newEmployeeJO.get("base"),
                            (String) newEmployeeJO.get("project"),
                            (Double) newEmployeeJO.get("budget"),
                            (Double) newEmployeeJO.get("portion")
                        );
                        employees.add(newEmployee);
                    }

                    if (position.equals("Tester") ){
                        Tester newEmployee = new Tester(
                            (String) newEmployeeJO.get("id"),
                            (String) newEmployeeJO.get("fio"),
                            (Double) newEmployeeJO.get("base"),
                            (String) newEmployeeJO.get("project"),
                            (Double) newEmployeeJO.get("budget"),
                            (Double) newEmployeeJO.get("portion")
                        );
                        employees.add(newEmployee);
                    }

                    if (position.equals("Manager") ){
                        Manager newEmployee = new Manager(
                                (String) newEmployeeJO.get("id"),
                                (String) newEmployeeJO.get("fio"),
                                (String) newEmployeeJO.get("project"),
                                (Double) newEmployeeJO.get("budget"),
                                (Double) newEmployeeJO.get("portion")
                        );
                        employees.add(newEmployee);
                    }

                    if (position.equals("ProjectManager") ){
                        ProjectManager newEmployee = new ProjectManager(
                                (String) newEmployeeJO.get("id"),
                                (String) newEmployeeJO.get("fio"),
                                (String) newEmployeeJO.get("project"),
                                (Double) newEmployeeJO.get("budget"),
                                (Double) newEmployeeJO.get("portion"),
                                (Long) newEmployeeJO.get("subordinates")
                        );
                        employees.add(newEmployee);
                    }

                    if (position.equals("SeniorManager") ){
                        SeniorManager newEmployee = new SeniorManager(
                                (String) newEmployeeJO.get("id"),
                                (String) newEmployeeJO.get("fio"),
                                (String) newEmployeeJO.get("project"),
                                (Double) newEmployeeJO.get("budget"),
                                (Double) newEmployeeJO.get("portion"),
                                (Long) newEmployeeJO.get("subordinates")
                        );
                        employees.add(newEmployee);
                    }
                }
                reader.close();
            } catch (FileNotFoundException e) {
                System.err.println(e.toString());
            }
            catch (IOException e) {
                System.err.println(e.toString());
            }
        return employees ;
    }
}
