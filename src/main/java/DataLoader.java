import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataLoader {
    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private String position;
    @Expose
    private double base;
    @Expose
    private String project;

    DataLoader() {
        id = -1;
        name = "";
        position = "";
        base = 0.0d;
        project = "";
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public String getPosition() {return position;}
    public double getBase() {return base;}
    public String getProject() {return project;}

    public static double getProjectBudgets(String project) {
        double budget1 = 300000.0d, budget2 = 250000.0d;
        if (project.equals("проект 1")) {
            return budget1;
        }
        else if (project.equals("проект 2")) {
            return budget2;
        }
        else if (project.equals("все проекты")) {
            return budget1 + budget2;
        }
        else {
            return 0.0d;
        }
    }

    private int getProjectEmployeeNum(String project, String position) {
        if (position.equals("старший менеджер")) {
            return 9;
        }
        if (project.equals("проект 1")) {
            if (position.equals("тимлидер")){
                return 6;
            }
            else if (position.equals("менеджер проекта")){
                return 3;
            }
        }
        else if (project.equals("проект 2")) {
            if (position.equals("тимлидер")){
                return 11;
            }
            else if (position.equals("менеджер проекта")){
                return 4;
            }
        }
        return 0;
    }

    public Employee createObj() {
        Employee obj = null;
        int num = getProjectEmployeeNum(project, position);
        if (position.equals(("программист"))) {
            obj = new Programmer(id, name, position, base, 0.02, project);
        }
        else if (position.equals(("тестер"))) {
            obj = new Tester(id, name, position, base, 0.01, project);
        }
        else if (position.equals(("водитель"))) {
            obj = new Driver(id, name, position, base);
        }
        else if (position.equals(("уборщик"))) {
            obj = new Cleaner(id, name, position, base);
        }
        else if (position.equals(("тимлидер"))) {
            obj = new TeamLeader(id, name, position, base, 0.02, project, 1000, num);
        }
        else if (position.equals(("менеджер"))) {
            obj = new Manager(id, name, position, 0.2,  project);
        }
        else if (position.equals(("менеджер проекта"))) {
            obj = new ProjectManager(id, name, position, 0.25,  project, 3500, num);
        }
        else if (position.equals(("старший менеджер"))) {
            obj = new SeniorManager(id, name, position, 0.25,  project, 4500, num);
        }
        return obj;
    }

    private static Gson gsonObj() {
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        builder.setPrettyPrinting();
        return builder.create();
    }

    public static ArrayList<DataLoader> readInputData(String fileName) {
        ArrayList<DataLoader> arr = null;
        Gson gson = gsonObj();
        String absPath = System.class.getResource("/" + fileName).getFile();
        Type arrType = new TypeToken<ArrayList<DataLoader>>(){}.getType();
        File file = null;
        FileReader fileReader = null;
        BufferedReader reader = null;
        try {
            file = new File(absPath);
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            arr = gson.fromJson(reader, arrType);
            if (!arr.isEmpty() && file.canRead() && (file.length() > 0L)) {
                System.out.println("Данные сотрудников загружены из файла.");
            }
            else {
                System.out.println("Данные сотрудников загружены НЕ корректно.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Данные сотрудников НЕ загружены.");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Данные сотрудников НЕ загружены.");
        }
        return arr;
    }
}
