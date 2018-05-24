import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

class FileWork {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private List list;
    private File f;

    FileWork(File f,List list){
        this.f=f;
        this.list=list;
    }

    void readFromFile() {
        try {
            FileInputStream fInputStream = new FileInputStream(f);
            workbook = new XSSFWorkbook(fInputStream);
            sheet = workbook.getSheetAt(0);
            for (int r = 0; r < sheet.getLastRowNum() + 1; r++) {
                row = sheet.getRow(r);
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase("cleaner")) {
                    list.add(new Cleaner((int) row.getCell(1).getNumericCellValue(),
                            row.getCell(2).getStringCellValue(),
                            row.getCell(3).getNumericCellValue(),
                            row.getCell(4).getNumericCellValue(),
                            row.getCell(5).getNumericCellValue())
                    );
                    continue;
                }
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase("driver")) {
                    list.add(new Cleaner((int) row.getCell(1).getNumericCellValue(),
                            row.getCell(2).getStringCellValue(),
                            row.getCell(3).getNumericCellValue(),
                            row.getCell(4).getNumericCellValue(),
                            row.getCell(5).getNumericCellValue()
                            )
                    );
                    continue;
                }
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase("programmer")) {
                    list.add(new Programmer((int) row.getCell(1).getNumericCellValue(),
                            row.getCell(2).getStringCellValue(),
                            row.getCell(3).getNumericCellValue(),
                            row.getCell(4).getNumericCellValue(),
                            row.getCell(5).getNumericCellValue(),
                            row.getCell(7).getStringCellValue()
                            )
                    );
                    continue;
                }
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase("tester")) {
                    list.add(new Tester((int) row.getCell(1).getNumericCellValue(),
                            row.getCell(2).getStringCellValue(),
                            row.getCell(3).getNumericCellValue(),
                            row.getCell(4).getNumericCellValue(),
                            row.getCell(5).getNumericCellValue(),
                            row.getCell(7).getStringCellValue()
                            )
                    );
                    continue;
                }
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase("manager")) {
                    list.add(new Manager((int) row.getCell(1).getNumericCellValue(),
                            row.getCell(2).getStringCellValue(),
                            row.getCell(3).getNumericCellValue(),
                            row.getCell(5).getNumericCellValue(),
                            row.getCell(7).getStringCellValue()
                            )
                    );
                    continue;
                }
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase("teamleader")) {
                    list.add(new TeamLeader((int) row.getCell(1).getNumericCellValue(),
                            row.getCell(2).getStringCellValue(),
                            row.getCell(3).getNumericCellValue(),
                            row.getCell(4).getNumericCellValue(),
                            row.getCell(5).getNumericCellValue(),
                            (int) row.getCell(6).getNumericCellValue(),
                            row.getCell(7).getStringCellValue())
                    );
                    continue;
                }
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase("projectmanager")) {
                    list.add(new ProjectManager((int) row.getCell(1).getNumericCellValue(),
                            row.getCell(2).getStringCellValue(),
                            row.getCell(3).getNumericCellValue(),
                            row.getCell(5).getNumericCellValue(),
                            (int) row.getCell(6).getNumericCellValue(),
                            row.getCell(7).getStringCellValue()
                            )
                    );
                    continue;
                }
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase("seniormanager")) {
                    list.add(new SeniorManager((int) row.getCell(1).getNumericCellValue(),
                            row.getCell(2).getStringCellValue(),
                            row.getCell(3).getNumericCellValue(),
                            row.getCell(5).getNumericCellValue(),
                            (int) row.getCell(6).getNumericCellValue(),
                            row.getCell(7).getStringCellValue()
                            )
                    );
                    continue;
                }
            }
            workbook.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    void writeToFile() {
        FileOutputStream fOutputStream = null;
        try {
            fOutputStream = new FileOutputStream(f);
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Employees");
            row = sheet.createRow(0);
            row.createCell(0).setCellValue("Должность");
            row.createCell(1).setCellValue("ФИО");
            row.createCell(2).setCellValue("Отработанное время");
            row.createCell(3).setCellValue("Зарплата");
            for (int r = 1; r < list.size(); r++) {
                row = sheet.createRow(r);
                Employee emp= (Employee) list.get(r);
                row.createCell(0).setCellValue(emp.getClass().getName());
                row.createCell(1).setCellValue(emp.getName());
                row.createCell(2).setCellValue(emp.getWorktime());
                row.createCell(3).setCellValue(emp.getPayment());
            }
            sheet.autoSizeColumn(1);
            workbook.write(fOutputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
