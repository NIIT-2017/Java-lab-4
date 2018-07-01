//tutorial that i used https://tproger.ru/translations/how-to-read-write-excel-file-java-poi-example/
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ReadAndWrite {
    private List list;
    private File file;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;

    ReadAndWrite(File file, List list) {
        this.file = file;
        this.list = list;
    }

    void readFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheetAt(0);
            for(int i = 0; i < sheet.getLastRowNum() + 1; i++) {
                row = sheet.getRow(i);
                if(row.getCell(0).getStringCellValue().equalsIgnoreCase("programmer")) {
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
            }
            workbook.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeToFile(){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Employees");
            row = sheet.createRow(0);
            row.createCell(0).setCellValue("Должность");
            row.createCell(1).setCellValue("ФИО");
            row.createCell(2).setCellValue("Отработанное время");
            row.createCell(3).setCellValue("Заробатная плата");
            for (int j = 1; j < list.size(); j++) {
                row = sheet.createRow(j);
                Employee employee = (Employee) list.get(j);
                row.createCell(0).setCellValue(employee.getClass().getName());
                row.createCell(1).setCellValue(employee.getName());
                row.createCell(2).setCellValue(employee.getWorktime());
                row.createCell(3).setCellValue(employee.getPayment());
            }
            sheet.autoSizeColumn(1);
            workbook.write(fileOutputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
