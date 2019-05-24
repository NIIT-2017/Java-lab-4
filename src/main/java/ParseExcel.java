import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ParseExcel {
    public static void readFromExcel(String file) throws IOException {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
        //XSSFRow row = myExcelSheet.getRow(1);
        Iterator<Row> rowIterator = myExcelSheet.iterator();
        Row row = rowIterator.next();
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();
            int id = (int) cell.getNumericCellValue();
            cell = cellIterator.next();
            String fio = cell.getStringCellValue();
            cell = cellIterator.next();
            String position = cell.getStringCellValue();
            cell = cellIterator.next();
            int base = (int) cell.getNumericCellValue();
            //System.out.println(id + fio + position + base);
            cell = cellIterator.next();
            int project = (int) cell.getNumericCellValue();
            if (position.equals("Cleaner")) {
                employees.add(new Cleaner(id, fio, base));
            }
            if (position.equals("Driver")) {
                employees.add(new Driver(id, fio, base));
            }
            if (position.equals("Programmer")) {
                employees.add(new Programmer(id, fio, base, project));
            }
            if (position.equals("Tester")) {
                employees.add(new Tester(id, fio, base, project));
            }
            if (position.equals("TeamLeader")) {
                employees.add(new TeamLeader(id, fio, base, project, 2));
            }
            if (position.equals("ProjectManager")) {
                employees.add(new ProjectManager(id, fio, base, 5));
            }
            if (position.equals("SeniorManager")) {
                employees.add(new SeniorManager(id, fio, base, 3));
            }
        }
        for (Employee x : employees) {
            System.out.println(x.name + " " + " " + x.calcSalary());
        }
        myExcelBook.close();
    }

}
