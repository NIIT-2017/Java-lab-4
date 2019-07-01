import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        String textEmployees = ReaderUtils.readTextFromFile("testdata.txt");
        Type typeEmployees = new TypeToken<ArrayList<Employee>>(){}.getType();

        ArrayList<Employee> employees;
        employees = new Gson().fromJson(textEmployees, typeEmployees);
        PaymentHelper paymentHelper = new PaymentHelper(employees);
        System.out.printf("%20s %10s %10s %10s",
                "Должность",
                "Имя",
                "Часы",
                "з/п");
        System.out.println("");
        for (Employee employee : employees){
            System.out.printf("%20s %10s %10s %10s",
                    employee.position.toString(),
                    employee.name,
                    String.valueOf(employee.workload),
                    String.valueOf(EmployeeFactory.getEmployee(employee).calculatePayment(paymentHelper)));
            System.out.println("");
        }
    }
}
