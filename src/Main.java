import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Main {
    static int employeesCount = 0;

    public static void main(String args[]) {
        // Collection for all emloyees
        ArrayList<Employee> employees = new ArrayList<Employee>();

        readInputFile(employees);

        writeWorkbook(employees);

    }


    public static void readInputFile(ArrayList<Employee> employees) {
        int id;
        String name;
        int worktime;
        float payment;
        float projectShare;
        String position;

        // Open the 1-st page of the input file
        HSSFWorkbook inputFile = readWorkbook("input.xls");
        HSSFSheet sheet = inputFile.getSheet("Лист1");

        // Read rows
        Iterator rowIter = sheet.rowIterator();
        while (rowIter.hasNext()) {
            HSSFRow row = (HSSFRow) rowIter.next();

            try {
                int cellNumber = 0;
                // Read cells in a row
                HSSFCell cell = row.getCell(cellNumber);
                id = (int) cell.getNumericCellValue();

                cell = row.getCell(++cellNumber);
                name = cell.getRichStringCellValue().getString();

                cell = row.getCell(++cellNumber);
                worktime = (int) cell.getNumericCellValue();

                cell = row.getCell(++cellNumber);
                payment = (float) cell.getNumericCellValue();


                cell = row.getCell(++cellNumber);
                projectShare = (float) cell.getNumericCellValue();

                cell = row.getCell(++cellNumber);
                position = cell.getRichStringCellValue().getString();


                // Add a new employee
                addEmployee(id, name, worktime, payment, projectShare, position, employees);

            } catch (Exception e) {
                System.out.println("Wrong string in input file!!");
            }
        }

        // Close file
        try {
            inputFile.close();
        } catch (Exception e) {
            System.out.println("Unable to close inputFile!");
        }
    }

    public static HSSFWorkbook readWorkbook(String filename) {
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filename));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            return wb;
        } catch (Exception e) {
            return null;
        }
    }


    public static void addEmployee(int id, String name, int worktime, float payment, float projectShare, String position,
                                   ArrayList<Employee> employees) {
        if (position.equals("Cleaner")) {
            employees.add(new Cleaner(id, name, worktime, payment));
        } else if (position.equals("Driver")) {
            employees.add(new Driver(id, name, worktime, payment));
        } else if (position.equals("Programmer")) {
            Main.employeesCount++;
            employees.add((new Programmer(id, name, worktime, payment, projectShare)));
        } else if (position.equals("Tester")) {
            Main.employeesCount++;
            employees.add((new Tester(id, name, worktime, payment, projectShare)));
        } else if (position.equals("TeamLeader")) {
            employees.add(new TeamLeader(id, name, worktime, payment, projectShare));
        } else if (position.equals("ProjectManager")) {
            employees.add(new ProjectManager(id, name, worktime, payment, projectShare));
        } else if (position.equals("SeniorManager")) {
            employees.add(new SeniorManager(id, name, worktime, payment, projectShare));
        }
    }

    public static void writeWorkbook(ArrayList<Employee> employees) {
        try {
            FileOutputStream out = new FileOutputStream("output.xls");
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet();

            int rowNumber=0;
            // Create the table head
            HSSFRow row=sheet.createRow(rowNumber);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(new HSSFRichTextString("id"));
            cell = row.createCell(1);
            cell.setCellValue(new HSSFRichTextString("name"));
            cell = row.createCell(2);
            cell.setCellValue(new HSSFRichTextString("salary"));

            for (Employee worker:employees){
                int cellNumber=0;

                row=sheet.createRow(++rowNumber);
                cell = row.createCell(cellNumber);
                cell.setCellValue(worker.getId());
                cell = row.createCell(++cellNumber);
                cell.setCellValue(new HSSFRichTextString(worker.getName()));
                cell = row.createCell(++cellNumber);
                cell.setCellValue(worker.calculateSalary());
            }


            wb.write(out);
            out.close();
        } catch (Exception e){
            System.out.println("Unable to write OutputFile!");
        }

    }

}
