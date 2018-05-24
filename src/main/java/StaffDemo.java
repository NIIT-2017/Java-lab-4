
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StaffDemo {
    public static void main(String[] args) {

        List<Employee> listEmployees = new ArrayList<Employee>();
        File fIn = new File("employees.xls").getAbsoluteFile();
        File fOut = new File("payment.xls").getAbsoluteFile();
        new FileWork(fIn,listEmployees).readFromFile();

        for (Employee e : listEmployees)
            e.CalcPayment();

        for (Employee e : listEmployees)
            System.out.println(e.getName() + " " + e.getPayment());
        new FileWork(fOut,listEmployees).writeToFile();

    }
}
