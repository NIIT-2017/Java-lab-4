import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bookkeeping {
    void setDriverList(byte id, String name, short base) {
        list.add(new Driver(id, name, base) {
        });
    }

    void setCleanerList(byte id, String name, short base) {
        list.add(new Cleaner(id, name, base) {
        });
    }

    void setProgrammerList(byte id, String name, short base, byte percent, String project) {
        list.add(new Programmer(id, name, base, percent, project) {
        });
    }

    void setTesterList(byte id, String name, short base, byte percent, String project) {
        list.add(new Tester(id, name, base, percent, project) {
        });
    }

    void setTeamLeaderList(byte id, String name, short base, byte percent, String project, byte numberEmployees) {
        list.add(new TeamLeader(id, name, base, percent, project, numberEmployees) {
        });
    }

    void setManagerList(byte id, String name, byte percent, String project) {
        list.add(new Manager(id, name, percent, project) {
        });
    }

    void setProjectManagerList(byte id, String name, byte percent, String project, byte numberEmployees) {
        list.add(new ProjectManager(id, name, percent, project, numberEmployees) {
        });
    }

    void setSeniorManagerList(byte id, String name, byte percent, String project, byte percent_1, String project_1, byte percent_2, String project_2, byte numberEmployees) {
        list.add(new SeniorManager(id, name, percent, project, percent_1, project_1, percent_2, project_2, numberEmployees) {
        });
    }

    Employee getBook(int num) {
        return list.get(num);
    }

    ArrayList<Employee> getBook() {
        return list;
    }

    private ArrayList<Employee> list = new ArrayList<Employee>();

    void createJson(String filename) {
        JSONArray obj = new JSONArray();
        for (int m = 0; m < list.size(); m++) {
            JSONObject men = new JSONObject();
            men.put("id", list.get(m).getId());
            men.put("name", list.get(m).getName());
            men.put("position",list.get(m).getPosition());
            switch (getBook(m).getPosition()) {
                case "Driver":
                    men.put("base", list.get(m).getBase());
                    break;
                case "Cleaner":
                    men.put("base", list.get(m).getBase());
                    break;
                case "Programmer":
                    men.put("base", list.get(m).getBase());
                    men.put("percent", list.get(m).getPercent());
                    men.put("project", list.get(m).getProject());
                    break;
                case "Tester":
                    men.put("base", list.get(m).getBase());
                    men.put("percent", list.get(m).getPercent());
                    men.put("project", list.get(m).getProject());
                case "TeamLeader":
                    men.put("base", list.get(m).getBase());
                    men.put("percent", list.get(m).getPercent());
                    men.put("project", list.get(m).getProject());
                    men.put("numberEmployees", list.get(m).getNumberEmployees());
                case "Manager":
                    men.put("percent", list.get(m).getPercent());
                    men.put("project", list.get(m).getProject());
                case "ProjectManager":
                    men.put("percent", list.get(m).getPercent());
                    men.put("project", list.get(m).getProject());
                    men.put("numberEmployees", list.get(m).getNumberEmployees());
                case "SeniorManager":
                    men.put("percent", list.get(m).getPercent());
                    men.put("project", list.get(m).getProject());
                    men.put("percent_1", list.get(m).getPercent_1());
                    men.put("project_1", list.get(m).getProject_1());
                    men.put("percent_2", list.get(m).getPercent_2());
                    men.put("project_2", list.get(m).getProject_2());
                    men.put("numberEmployees", list.get(m).getNumberEmployees());
            }
            obj.add(men);
        }
        try {
            FileWriter file = new FileWriter(filename);
            file.write(obj.toJSONString());

            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readJson(String filename){
        try {
            FileReader file = new FileReader(filename);
            JSONParser jsonParser = new JSONParser();
            try {
                JSONArray obj = (JSONArray) jsonParser.parse(file);
                for (int i = 0; i < obj.size(); i++){
                    JSONObject men = (JSONObject)obj.get(i);
                    switch ((String)men.get("position")) {
                        case "Driver":
                            setDriverList((byte)((Long) men.get("id")).longValue(),(String)men.get("name"),(short)((Long) men.get("base")).longValue());
                            break;
                        case "Cleaner":
                            setCleanerList((byte)((Long) men.get("id")).longValue(),(String)men.get("name"),(short)((Long) men.get("base")).longValue());
                            break;
                        case "Programmer":
                            setProgrammerList((byte)((Long) men.get("id")).longValue(),(String)men.get("name"),(short)((Long) men.get("base")).longValue(),
                                    (byte)((Long) men.get("percent")).longValue(),(String)men.get("project"));
                            break;
                        case "Tester":
                            setTesterList((byte)((Long) men.get("id")).longValue(),(String)men.get("name"),(short)((Long) men.get("base")).longValue(),
                                    (byte)((Long) men.get("percent")).longValue(),(String)men.get("project"));
                            break;
                        case "TeamLeader":
                            setTeamLeaderList((byte)((Long) men.get("id")).longValue(),(String)men.get("name"),(short)((Long) men.get("base")).longValue(),
                                    (byte)((Long) men.get("percent")).longValue(),(String)men.get("project"),(byte)((Long) men.get("numberEmployees")).longValue());
                            break;
                        case "Manager":
                            setManagerList((byte)((Long) men.get("id")).longValue(),(String)men.get("name"),(byte)((Long) men.get("percent")).longValue(),(String)men.get("project"));
                            break;
                        case "ProjectManager":
                            setProjectManagerList((byte)((Long) men.get("id")).longValue(),(String)men.get("name"),(byte)((Long) men.get("percent")).longValue(),
                                    (String)men.get("project"),(byte)((Long) men.get("numberEmployees")).longValue());
                            break;
                        case "SeniorManager":
                            setSeniorManagerList((byte)((Long) men.get("id")).longValue(),(String)men.get("name"),
                                    (byte)((Long) men.get("percent")).longValue(),(String)men.get("project"),
                                    (byte)((Long) men.get("percent_1")).longValue(),(String)men.get("project_1"),
                                    (byte)((Long) men.get("percent_2")).longValue(),(String)men.get("project_2"),
                                    (byte)((Long) men.get("numberEmployees")).longValue());
                            break;
                    }
                }
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
