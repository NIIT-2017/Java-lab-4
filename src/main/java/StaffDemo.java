/**
 * @author Pavel Belov
 * http://www.shtanyuk.tk/edu/nniit/java-new/labs/labs4.html
 * Lab №4
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDemo {
    public static void main(String[] args) {

        List<Employee> employeesList = new ArrayList<Employee>();
        File inputFile = new File("employees.xls").getAbsoluteFile();
        new ReadFile(inputFile, employeesList).readFromFile();

        for(Employee emp:employeesList)
            emp.calcPayment();

        for (Employee emp:employeesList)
            System.out.println(emp.getName() + " " + emp.getClass().getName() + " " + emp.getPayment() );
    }
}
