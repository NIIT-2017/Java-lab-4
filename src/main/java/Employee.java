import java.util.ArrayList;
import java.io.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


public abstract class Employee {
   protected int ID;
   protected String Name;
   protected int Worktime;
   protected double Payment;
   protected String function;

    protected abstract void calcPayment();

 }

interface Heading {
    double Payheading();
    int HeadingpaySubj = 5000;
}

interface WorkTime {
    double Payworktime();
}

interface Project {
    double Payproject();
    String getProject();
}


abstract class Engineer extends Employee implements WorkTime, Project {
    protected double Salary;
    protected String NameProject;
    protected double ProjectFund;
    protected int ProjectPerc;

    Engineer(int ID, int Worktime, String Name, double Salary, double ProjectFund, String NameProject, int ProjectPerc, String function){
        this.Salary = Salary;
        this.ID = ID;
        this.Name = Name;
        this.Worktime = Worktime;
        this.function = function;
        this.ProjectPerc = ProjectPerc;
        this.NameProject = NameProject;
        this.ProjectFund = ProjectFund;
    }

    protected void calcPayment() {
        Payment = Payworktime() + Payproject();
    }

    public double Payproject() {
        return ProjectFund * ProjectPerc/100;
    }

    public double Payworktime() {
        return Salary * Worktime;
    }

    public String getProject() {
        return NameProject;
    }
}

class Programmer extends Engineer{
    private double Payofgrade = 1.3;
    Programmer(int ID, int Worktime, String Name, double Salary, double ProjectFund, String NameProject, int ProjectPerc, String function){
        super(ID, Worktime, Name, Salary, ProjectFund, NameProject, ProjectPerc, function);
    }
    @Override
    protected void calcPayment() {
        Payment = Payworktime() * Payofgrade + Payproject();
    }
}

class Tester extends Engineer{
    Tester(int ID, int Worktime, String Name, double Salary, double ProjectFund, String NameProject, int ProjectPerc, String function){
        super(ID, Worktime, Name, Salary, ProjectFund, NameProject, ProjectPerc, function);
    }
}

class TeamLeader extends Programmer implements Heading{
    private int Numbersubject;
    TeamLeader(int ID, int Worktime, String Name, double Salary, double ProjectFund, String NameProject, int ProjectPerc, int Numbersubject, String function){
        super(ID, Worktime, Name, Salary, ProjectFund, NameProject, ProjectPerc, function);
        this.Numbersubject = Numbersubject;
    }

    @Override
    protected void calcPayment() {
        Payment = Payworktime() + Payproject() + Payheading();
    }

    public double Payheading() {
        return Numbersubject * HeadingpaySubj;
    }
}

abstract class Pesonal extends Employee implements WorkTime {
    protected double Salary;

    Pesonal(int ID, int Worktime, String Name, double Salary, String function){
        this.ID = ID;
        this.Name = Name;
        this.Worktime = Worktime;
        this.function = function;
        this.Salary = Salary;
    }

    protected void calcPayment() {
        Payment = Payworktime();
    }

    public double Payworktime() {
        return Salary * Worktime;
    }
}

class Cleaner extends Pesonal{
    Cleaner(int ID, int Worktime, String Name, double Salary, String function){
        super(ID, Worktime, Name, Salary, function);
    }
}

class Driver extends Pesonal{
    private double Payovertime = 1.5;
    Driver(int ID, int Worktime, String Name, double Salary, String function){
        super(ID, Worktime, Name, Salary, function);
    }
    @Override
    protected void calcPayment(){
        Payment = Payworktime() * Payovertime;
    }
}

class Manager extends Employee implements  Project {
    protected String NameProject;
    protected double ProjectFund;
    protected int ProjectPerc;

    Manager(int ID, String Name, double ProjectFund, String NameProject, int ProjectPerc, String function){
        this.ID = ID;
        this.Name = Name;
        this.function = function;
        this.NameProject = NameProject;
        this.ProjectFund = ProjectFund;
        this.ProjectPerc = ProjectPerc;
    }

    protected void calcPayment() {
        Payment = Payproject();
    }

    public double Payproject() {
        return ProjectFund * ProjectPerc/100;
    }

    public String getProject() {
        return NameProject;
    }
}

class ProjectManager extends Manager implements Heading{
    protected int Numbersubject;

    ProjectManager(int ID, String Name, double ProjectFund, String NameProject, int ProjectPerc, int Numbersubject, String function) {
        super(ID, Name, ProjectFund, NameProject, ProjectPerc, function);
        this.Numbersubject = Numbersubject;
    }
    @Override
    protected void calcPayment(){
        Payment = Payproject() + Payheading();
    }

    public double Payheading() {
        return Numbersubject * HeadingpaySubj;
    }
}


class SeniorManager extends ProjectManager{

    SeniorManager(int ID, String Name, double ProjectFund, String NameProject, int ProjectPerc, int Numbersubject, String function){
        super(ID, Name, ProjectFund, NameProject, ProjectPerc, Numbersubject, function);
    }
}

class StaffDemo {
    private static ArrayList<Employee> personal;

    public static void main(String[] args) {
        createPersonal();
        calcPayments();
        createFile();

        Runtime r= Runtime.getRuntime();
        try
        {
            String cmd = "cmd /c start " + "src/main/resources/personal.xls";
            r.exec(cmd);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    private static void createFile() {

        final HSSFWorkbook workBook = new HSSFWorkbook();
        HSSFSheet Sheet = workBook.createSheet("personal");

        int rowNum = 0;

        Row row = Sheet.createRow(rowNum);

        row.createCell(0).setCellValue("№п/п");
        row.createCell(1).setCellValue("ФИО сотрудника");
        row.createCell(2).setCellValue("Должность");
        row.createCell(3).setCellValue("Отработанное время");
        row.createCell(4).setCellValue("Зарплата");
        for(int colNum = 0; colNum<row.getLastCellNum();colNum++)
            workBook.getSheetAt(0).autoSizeColumn(colNum);
        for (Employee dataModel : personal) {
            createSheetHeader(Sheet, ++rowNum, dataModel, workBook);
        }

        try (FileOutputStream out = new FileOutputStream(new File("src/main/resources/personal.xls"))) {
            workBook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан!");
    }
        private static void createSheetHeader(HSSFSheet sheet, int rowNum, Employee personal, HSSFWorkbook workBook) {
            Row row = sheet.createRow(rowNum);

            row.createCell(0).setCellValue(personal.ID);
            row.createCell(1).setCellValue(personal.Name);
            row.createCell(2).setCellValue(personal.function);
            row.createCell(3).setCellValue(personal.Worktime);
            row.createCell(4).setCellValue(personal.Payment);
            for(int colNum = 0; colNum<row.getLastCellNum();colNum++)
                workBook.getSheetAt(0).autoSizeColumn(colNum);
        }

    private static void createPersonal(){

        int Numbersubject=0;
        personal = new ArrayList<>();

        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
           InputStream is = cl.getResourceAsStream("personal.json");
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            JsonElement jsonElement = new JsonParser().parse(bf);
             JsonArray jsonArray= jsonElement.getAsJsonArray();
            if (jsonArray != null) {
                for (int i = 0; i< jsonArray.size(); i++){
                    JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                    String Name = String.valueOf((jsonObject.get("Name")));
                    int ID = Integer.parseInt(String.valueOf((jsonObject.get("ID"))));
                    String function = String.valueOf((jsonObject.get("function")));

                    if (function.replace("\"","").equals("Programmer") || function.replace("\"","").equals("Tester") || function.replace("\"","").equals("TeamLeader")) {
                        int Worktime = Integer.parseInt(String.valueOf(jsonObject.get("Worktime")));
                        int Salary = Integer.parseInt(String.valueOf(jsonObject.get("Salary")));
                        String NameProject = (String.valueOf((jsonObject.get("NameProject"))));
                        int ProjectPerc = Integer.parseInt(String.valueOf(jsonObject.get("ProjectPerc")));
                        double ProjectFund = Double.parseDouble(String.valueOf(jsonObject.get("ProjectFund")));

                        switch (function.replace("\"","")) {
                            case "Programmer":
                                personal.add(new Programmer(ID, Worktime, Name, Salary, ProjectFund, NameProject, ProjectPerc,function));
                                break;
                            case "Tester":
                                personal.add(new Tester(ID, Worktime, Name, Salary, ProjectFund, NameProject, ProjectPerc,function));
                                break;
                            case "TeamLeader":
                                Numbersubject = Integer.parseInt(String.valueOf(jsonObject.get("Numbersubject")));
                                personal.add(new TeamLeader(ID, Worktime, Name, Salary, ProjectFund, NameProject, ProjectPerc, Numbersubject,function));

                            break;
                        }
                    }
                    else if (function.replace("\"","").equals("Cleaner")|| function.replace("\"","").equals("Driver")) {
                        int Worktime = Integer.parseInt(String.valueOf(jsonObject.get("Worktime")));
                        int Salary = Integer.parseInt(String.valueOf(jsonObject.get("Salary")));

                        switch (function.replace("\"","")) {
                            case "Cleaner":
                                personal.add(new Cleaner(ID, Worktime, Name, Salary,function));
                                break;
                            case "Driver":
                                personal.add(new Driver(ID, Worktime, Name, Salary,function));
                                break;
                        }
                    }
                     else {
                        String NameProject = (String.valueOf((jsonObject.get("NameProject"))));
                        int ProjectPerc = Integer.parseInt(String.valueOf(jsonObject.get("ProjectPerc")));
                        double ProjectFund = Double.parseDouble(String.valueOf(jsonObject.get("ProjectFund")));

                        switch (function.replace("\"","")) {
                            case "Manager":
                                personal.add(new Manager(ID, Name, ProjectFund, NameProject, ProjectPerc,function));
                            break;

                            case "ProjectManager":
                                Numbersubject = Integer.parseInt(String.valueOf(jsonObject.get("Numbersubject")));
                                personal.add(new ProjectManager(ID, Name, ProjectFund, NameProject, ProjectPerc, Numbersubject,function));

                            break;

                            case "SeniorManager":
                                Numbersubject = Integer.parseInt(String.valueOf(jsonObject.get("Numbersubject")));
                                personal.add(new SeniorManager(ID, Name, ProjectFund, NameProject, ProjectPerc, Numbersubject,function));
                            break;
                        }
                    }
                }
            }

        }
        catch (Exception  e) {
            e.printStackTrace();
        }
    }

    private static void calcPayments() {
        for (Employee i:personal) {
            i.calcPayment();
        }
    }
}