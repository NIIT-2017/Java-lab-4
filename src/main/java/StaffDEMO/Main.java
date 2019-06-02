package StaffDEMO;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Main{
    static ArrayList<Employee> staff = new ArrayList<Employee>();


    public static void main(String[]args) {
        InputStream input = null;
        XSSFWorkbook workbook = null;
        try {
            input = new FileInputStream("staff.xlsx");
            workbook = new XSSFWorkbook(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        int count = 0;
        Row row;
        row = rowIterator.next();
        while(rowIterator.hasNext()){
            row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();
            int id = (int) cell.getNumericCellValue();
            cell = cellIterator.next();
            String name = cell.getStringCellValue();
            cell = cellIterator.next();
            String job = cell.getStringCellValue();
            cell = cellIterator.next();
            double price = cell.getNumericCellValue();
            cell = cellIterator.next();
            String project = cell.getStringCellValue();
            cell = cellIterator.next();
            double part = cell.getNumericCellValue();
            cell = cellIterator.next();
            double budget = cell.getNumericCellValue();
            cell = cellIterator.next();
            double base = cell.getNumericCellValue();
            cell = cellIterator.next();
            double worktime = cell.getNumericCellValue();
            if(job.equals("ProjectManager")){
                staff.add(new ProjectManager(id, name, worktime, price, base, part, project, 10, budget));
            }
            if(job.equals("SeniorManager")){
                staff.add(new SeniorManager(id, name, worktime, price, base, part, project, 20, budget));
            }
            if(job.equals("TeamLeader")){
                staff.add(new TeamLeader(id, name, worktime, base, project, part, budget, 3));
            }
            if(job.equals("Programmer")){
                staff.add(new Programmer(id, name, worktime, base, project, part, budget));
            }
            if(job.equals("Tester")){
                staff.add(new Tester(id, name, worktime, base, project, part, budget));
            }
            if(job.equals("Cleaner")){
                staff.add(new Cleaner(id, name, worktime, base));
            }
            if (job.equals("Driver")){
                staff.add(new Driver(id, name, worktime, base));
            }
            System.out.println(staff.get(count).getPayment());
            count++;
        }
        for (Employee worker:
             staff) {
            Class<?> workerClass = worker.getClass();
            System.out.println(worker.name + " " + workerClass + " " + worker.getPayment());
        }
        row.setRowNum(1);
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
