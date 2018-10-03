package employee;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Employee{
    private int id;
    private String name;
    private double workTime;
    private double payment;
    private double base;
    private Map<String, Double[]> project= new LinkedHashMap();
    private String position;
    private int subordinates;
    @Override
    public String toString() {
        return "Id: "+id+" Должность: "+position+" ФИО: "+name+" Зарплата ="+payment;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBase(double base){
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    public void setWorkTime(double workTime){
        this.workTime = workTime;
    }

    public double getWorkTime(){
        return workTime;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getPayment() {
        return payment;
    }

    public void setSubordinates(int subordinates){
        this.subordinates = subordinates;
    }

    public int getSubordinates() {
        return subordinates;
    }

    public Map<String, Double[]> getProject() {
        return project;
    }

    public void setProject(String title, Double[] values ){
        project.put(title, values);
    }

    public Object[] getProjectTitle() {
        Set<String> projects = project.keySet();
        return projects.toArray();
    }
}
