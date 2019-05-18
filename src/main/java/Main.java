import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
    static ArrayList<Employee> staff = new ArrayList<Employee>();
    static Map<String, Integer> projects = new HashMap<String, Integer>();
    static Map<String, Integer> memberOfProject = new HashMap<String, Integer>();
    static int totalProjectMoney = 0;

    public static void main(String[] args) throws Exception {
        InputStream inp = new FileInputStream("staff.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inp);
        XSSFSheet sheet = workbook.getSheetAt(1);
        Iterator<Row> rowIterator = sheet.iterator();
        Row row = rowIterator.next();
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();
            String project = cell.getStringCellValue();
            cell = cellIterator.next();
            int budget = (int) cell.getNumericCellValue();
            totalProjectMoney += budget;
            projects.put(project, budget);
            memberOfProject.put(project, 0);
        }
        projects.put("N", 0);
        sheet = workbook.getSheetAt(0);
        rowIterator = sheet.iterator();
        row = rowIterator.next();
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();
            int id = (int) cell.getNumericCellValue();
            cell = cellIterator.next();
            String name = cell.getStringCellValue();
            cell = cellIterator.next();
            String position = cell.getStringCellValue();
            cell = cellIterator.next();
            int worktime = (int) cell.getNumericCellValue();
            cell = cellIterator.next();
            String project = cell.getStringCellValue();
            int projectMoney = projects.get(project);
            cell = cellIterator.next();
            int rate = (int) cell.getNumericCellValue();
            cell = cellIterator.next();
            double part = cell.getNumericCellValue();
            cell = cellIterator.next();
            int one = (int) cell.getNumericCellValue();
            if (position.equals("Cleaner")) {
                Cleaner emp = new Cleaner(id, name, rate);
                emp.worktime = worktime;
                staff.add(emp);
            }
            if (position.equals("Driver")) {
                Driver emp = new Driver(id, name, rate);
                emp.worktime = worktime;
                staff.add(emp);
            }
            if (position.equals("Tester")) {
                Tester emp = new Tester(id, name, projectMoney, part, rate);
                memberOfProject.put(project, memberOfProject.get(project) + 1);
                emp.worktime = worktime;
                staff.add(emp);
            }
            if (position.equals("Programmer")) {
                Programmer emp = new Programmer(id, name, projectMoney, part, rate);
                memberOfProject.put(project, memberOfProject.get(project) + 1);
                emp.worktime = worktime;
                staff.add(emp);
            }
            if (position.equals("TeamLeader")) {
                TeamLeader emp = new TeamLeader(id, name, projectMoney, part, rate, one);
                emp.number = memberOfProject.get(project);
                emp.worktime = worktime;
                staff.add(emp);
            }
            if (position.equals("ProjectManager")) {
                ProjectManager emp = new ProjectManager(id, name, projectMoney, part, one);
                emp.number = memberOfProject.get(project) + 1;
                emp.worktime = worktime;
                staff.add(emp);
            }
            if (position.equals("SenjorManager")) {
                SenjorManager emp = new SenjorManager(id, name, totalProjectMoney, part, one);
                emp.number = staff.size();
                emp.worktime = worktime;
                staff.add(emp);
            }
        }
        inp.close();


        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Salary");
        row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("id");
        cell=row.createCell(1);
        cell.setCellValue("name");
        cell=row.createCell(2);
        cell.setCellValue("worktime");
        cell=row.createCell(3);
        cell.setCellValue("salary");
        for (int i=0;i<staff.size();i++)
        {
            row = sheet.createRow(i+1);
            cell=row.createCell(0);
            cell.setCellValue(staff.get(i).id);
            cell=row.createCell(1);
            cell.setCellValue(staff.get(i).name);
            cell=row.createCell(2);
            cell.setCellValue(staff.get(i).worktime);
            cell=row.createCell(3);
            staff.get(i).calc();
            cell.setCellValue(staff.get(i).payment);
        }
        FileOutputStream fileOut = new FileOutputStream("salary.xlsx");
        workbook.write(fileOut);
        workbook.close();
        fileOut.close();
    }
}
