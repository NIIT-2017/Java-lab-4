import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

//Класс парсит файл в JSON формате, создает Объекты соответственных классов, выводит результат в консоль
public class StaffReader {
    public static final double PRO1 = 1000000.0, PRO2 = 1200000.0, PRO3 = 850000.0; //бюджеты проектов
    public static final double PROG_rating = 0.04;              //вклад Программиста в проект
    public static final double TEST_rating = 0.03;              //вклад Тестера
    public static final double TL_rating = 0.13;                //вклад Ведущего программиста
    public static final double MNG_rating = 0.05;               //вклад Менеджера
    public static final double PROJ_MNG_rating = 0.2;           //вклад Проектного менеджера
    public static final double SENJOR_MNG_rating = 0.1;         //вклад Руководителя (по 10% от всех проектов)

    private List<Employee> staff = new ArrayList<Employee>();                      //все сотрудники

    public List<Employee> addStaffFromFile(String filename) {
        try {
            File file = new File(filename);
            FileReader reader = new FileReader(file);
            JsonParser jsonParser = new JsonParser();                              //создание парсера
            JsonObject jsonObject = (JsonObject) jsonParser.parse(reader);         //объект из JSON файла
            JsonArray jsonStaff = (JsonArray) jsonObject.get("staff");             //массив из JSON объектов
            for (JsonElement employee : jsonStaff) {
                int id;
                double base;
                String name, position, project;
                JsonObject tempEmployee = employee.getAsJsonObject();          //временный сотрудник
                id = tempEmployee.get("id").getAsInt();                        //id сотрудника
                name = tempEmployee.get("name").getAsString();                 //fio сотрудника
                position = tempEmployee.get("position").getAsString();         //должность сотрудника
                if (tempEmployee.get("base").getAsDouble() != 0) {
                    base = tempEmployee.get("base").getAsDouble();             //начальная ставка зп
                } else base = 0;
                if (tempEmployee.get("project").toString().trim().length() != 0) {
                    project = tempEmployee.get("project").getAsString();       //проект, в кот.участвует сотрудник
                } else project = null;

                //распределяем сотрудников по должностям
                int num;                        //количество подчиненных в зависимости от должности руководителя
                double payForEmp;               //премия за одного сотрудника в подчинении

                if (position.equals("Cleaner")) {
                    Employee cleanerNew = new Cleaner(id, name, 0, 0, base);
                    staff.add(cleanerNew);
                } else if (position.equals("Driver")) {
                    Employee driverNew = new Driver(id, name, 0, 0, base);
                    staff.add(driverNew);
                } else if (position.equals("Programmer")) {
                    Employee progNew = new Programmer(id, name, 0, 0, project, base, PROG_rating);
                    staff.add(progNew);
                } else if (position.equals("Tester")) {
                    Employee testerNew = new Tester(id, name, 0, 0, project, base, TEST_rating);
                    staff.add(testerNew);
                } else if (position.equals("TeamLeader")) {
                    num = 4;
                    payForEmp = 3000;
                    Employee tlNew = new TeamLeader(id, name, 0, 0, project, base, TL_rating, num, payForEmp);
                    staff.add(tlNew);
                } else if (position.equals("Manager")) {
                    Employee managerNew = new Manager(id, name, 0, project, MNG_rating);
                    staff.add(managerNew);
                } else if (position.equals("ProjectManager")) {
                    num = 3;
                    payForEmp = 3500;
                    Employee projmanNew = new ProjectManager(id, name, 0, project, PROJ_MNG_rating, num, payForEmp);
                    staff.add(projmanNew);
                } else if (position.equals("SeniorManager")) {
                    num = 12;
                    payForEmp = 5000;
                    Employee seniorNew = new SeniorManager(id, name, 0, project, SENJOR_MNG_rating, num, payForEmp, 0, base);
                    staff.add(seniorNew);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Data not found!");
        }
        return staff;
    }

    public static double getBudgetProject(String project) {
        if (project.equals("Project1"))
            return PRO1;
        else if (project.equals("Project2"))
            return PRO2;
        else if (project.equals("Project3"))
            return PRO3;
        else if (project.equals("All"))
            return PRO1 + PRO2 + PRO3;
        else return 0.0;
    }

    public void printResults() {
        String border = "—————————————————————————————————————————————————";
        System.out.printf("%-33s%-18s%s%s%n", "| ФИО", "| Должность", "| Время работы ", "| Зарплата |");
        System.out.println(border);
        for (Employee emp : staff) {
            System.out.printf("%-33s%-18s%-15s%-10s%s%n", "| " + emp.getName(), "| " + emp.getClass().getName(),
                    "| " + emp.getWorkTime(), "| " + emp.getPayment(), " |");
        }
        System.out.println(border);
    }
}

