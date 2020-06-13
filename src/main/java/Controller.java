import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

    public static Controller controller;
    private ArrayList<Employee> WorkersList = new ArrayList<Employee>();

    static Controller init (){
        controller = new Controller();
        return controller;
    }

    public void addWorker() {                          // создание отрудников на основе данных из файла
        JSONParser parserWorker = new JSONParser();

        try {
            FileReader reader = new FileReader("src/Worker.json");
            Object obj = parserWorker.parse(reader);
            JSONObject jsonList = (JSONObject) obj;
            JSONArray workersJsList = (JSONArray) jsonList.get("workers");

            for (int numWorker = 0; numWorker < workersJsList.size(); numWorker++) {
                JSONObject workerJson = (JSONObject) workersJsList.get(numWorker);

                int id = Integer.parseInt(workerJson.get("id").toString());
                String name = (String) workerJson.get("name");
                String position = (String) workerJson.get("position");
                int base = Integer.parseInt(workerJson.get("base").toString());
                int project = Integer.parseInt(workerJson.get("project").toString());

                if (position.equals ("Cleaner")) {
                    Employee cleaner = new Cleaner(id, name, position, base, 176);
                    WorkersList.add(cleaner);
                } else if (position.equals ("Driver")) {
                    Employee driver = new Driver(id, name, position, base, 176);
                    WorkersList.add(driver);
                } else if (position.equals ("Programmer")) {
                    Employee programmer = new Programmer(id, name, position, base, project, (int) (Math.random() * ((176 - 160) + 1)) + 160);
                    WorkersList.add(programmer);
                } else if (position.equals ("Tester")) {
                    Employee tester = new Tester(id, name, position, base, project, (int) (Math.random() * ((176 - 160) + 1)) + 160);
                    WorkersList.add(tester);
                } else if (position.equals ("ProjectManager")) {
                    Employee projectManager = new ProjectManager(id, name, position, project);
                    WorkersList.add(projectManager);
                } else if (position.equals ("TeamLeader")) {
                    Employee teamLeader = new TeamLeader(id, name, position, base);
                    WorkersList.add(teamLeader);
                } else if (position.equals ("SeniorManager")) {
                    Employee seniorManager = new SeniorManager(id, name, position, base);
                    WorkersList.add(seniorManager);
                }
            }
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    public int getNumberEngineer() {
            int NumberEngineer = 0;
            for (Employee worker : WorkersList) {
                if (worker.position.equals ("Tester") || worker.position.equals ("Programmer")) {
                    NumberEngineer++;
                }
            }
            return NumberEngineer;
    }

    public int getNumberManager() {
        int NumberManager = 0;
        for (Employee worker : WorkersList) {
            if (worker.position.equals ("ProjectManager")) {
                NumberManager++;
            }
        }
        return NumberManager;
    }

    public void updated () {                                                                //сохранение обновленных данных в файлах
        try {
            JSONObject objList = new JSONObject();
            JSONArray updatedWorkersList = new JSONArray();

                for (Employee worker : WorkersList) {

                    int id = worker.getId();
                    String position = worker.position;
                    String name = worker.getName();
                    int salary = worker.calculateSalary();


                    JSONObject objWorker = new JSONObject();
                    objWorker.put("id", id);
                    objWorker.put("position", position);
                    objWorker.put("name", name);
                    objWorker.put("salary", salary);

                    System.out.println("Id: " + id + "\t\t" + "Position: " + position + "\t\t" + "Name: " + name + "\t\t" + "Salary for month: " + salary);

                    updatedWorkersList.add(objWorker);

                }

            objList.put("workers", updatedWorkersList);
            FileWriter file = new FileWriter("UPD.json");
            file.write(objList.toJSONString());
            file.flush();
                // оставить один трай и к нему кэтч
                // ты используешь трай с ресусрами, которыйне поддерживается стандартом
                // к тому же ты созлаешь объект в скобках и потом пытаешься его использовать. Думаю вне скобок этот объект уже не существует (объект file)
        }

        catch (Exception e) {
            System.out.println("Error 2!");
        }
    }
}
