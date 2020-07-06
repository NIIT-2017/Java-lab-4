import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParseToEmployee {
    private String filename;

    public ParseToEmployee(String filename){
        this.filename = filename;
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    private Driver createDriver(LinkedTreeMap<String, Object> map){
        double id = (double)map.get((Object)"id");
        Object name = map.get((Object)"name");
        double worktime = (double)map.get((Object)"worktime");
        double base = (double)map.get((Object)"base");
        Object category = map.get((Object)"category");
        //return new Driver((Integer)id, (String)name, (Integer)worktime, (Double)payment, DriverLicenseCategory.valueOf((String)category));
        return new Driver((int)id, (String)name, (int)worktime, base, DriverLicenseCategory.valueOf((String)category));
    }

    private Cleaner createCleaner(LinkedTreeMap<String, Object> map){
        double id = (double)map.get((Object)"id");
        Object name = map.get((Object)"name");
        double worktime = (double)map.get((Object)"worktime");
        double base = (double)map.get((Object)"base");
        return new Cleaner((int)id, (String)name, (int)worktime, base);
    }

    private Programmer createProgrammer(LinkedTreeMap<String, Object> map){
        double id = (double)map.get((Object)"id");
        Object name = map.get((Object)"name");
        double worktime = (double)map.get((Object)"worktime");
        double base = (double)map.get((Object)"base");
        Object project = map.get((Object)"project");
        return new Programmer((int)id, (String)name, (int)worktime, base, (String)project);
    }

    private Tester createTester(LinkedTreeMap<String, Object> map){
        double id = (double)map.get((Object)"id");
        Object name = map.get((Object)"name");
        double worktime = (double)map.get((Object)"worktime");
        double base = (double)map.get((Object)"base");
        Object project = map.get((Object)"project");
        return new Tester((int)id, (String)name, (int)worktime, base, (String)project);
    }

    private TeamLeader createTeamLeader(LinkedTreeMap<String, Object> map){
        double id = (double)map.get((Object)"id");
        Object name = map.get((Object)"name");
        double worktime = (double)map.get((Object)"worktime");
        double base = (double)map.get((Object)"base");
        Object project = map.get((Object)"project");
        double count = (double)map.get((Object)"count");
        return new TeamLeader((int)id, (String)name, (int)worktime, base, (String)project, (int)count);
    }

    private Manager createManager(LinkedTreeMap<String, Object> map){
        double id = (double)map.get((Object)"id");
        Object name = map.get((Object)"name");
        Object project = map.get((Object)"project");
        return new Manager((int)id, (String)name, (String) project);
    }

    private ProjectManager createProjectManager(LinkedTreeMap<String, Object> map){
        double id = (double)map.get((Object)"id");
        Object name = map.get((Object)"name");
        Object project = map.get((Object)"project");
        double count = (double)map.get((Object)"count");
        return new ProjectManager((int)id, (String)name, (String) project, (int)count);
    }

    private SeniorManager createSeniorManager(LinkedTreeMap<String, Object> map){
        double id = (double)map.get((Object)"id");
        Object name = map.get((Object)"name");
        double count = (double)map.get((Object)"count");
        return new SeniorManager((int)id, (String)name, (int)count);
    }

    public List<Employee> getEmployeesFromResources() throws IOException {
        List<Employee> employees = new ArrayList<>();
        InputStream is = getClass().getResourceAsStream(this.filename);
        String content = readFromInputStream(is);

        Gson gson = new Gson();
        Map<String, ArrayList<LinkedTreeMap<String, Object>>> mapJson = (Map<String, ArrayList<LinkedTreeMap<String, Object>>>) gson.fromJson(content, Map.class);
        ArrayList<LinkedTreeMap<String, Object>> arrayList = mapJson.get("employees");

        for(LinkedTreeMap<String, Object> map: arrayList){
            Object positionObject = map.get((Object)"position");
            if(positionObject instanceof String){
                String position = ((String)positionObject).toLowerCase();
                switch (position){
                    case ("водитель"):
                        employees.add(createDriver(map));
                        break;
                    case("уборщица"):
                        employees.add(createCleaner(map));
                        break;
                    case("программист"):
                        employees.add(createProgrammer(map));
                        break;
                    case("инженер по тестированию"):
                        employees.add(createTester(map));
                        break;
                    case("технический лидер"):
                        employees.add(createTeamLeader(map));
                        break;
                    case("менеджер"):
                        employees.add(createManager(map));
                        break;
                    case("проектный менеджер"):
                        employees.add(createProjectManager(map));
                        break;
                    case("ит директор"):
                        employees.add(createSeniorManager(map));
                        break;
                }
            }
        }
        return employees;
    }

}
