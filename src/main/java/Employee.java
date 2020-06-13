import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Employee {

    private int id;                                             // идентификационный номер
    private String name;                                        // ФИО
    public String position;                                    // должность

    Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public int calculateSalary() {
        int salary = 0;
        return salary;
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }
}