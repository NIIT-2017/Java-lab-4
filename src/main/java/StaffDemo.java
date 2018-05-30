import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class StaffDemo {
    private static void printResults(ArrayList<Employee> staff) {
        String line = "-------------------------------------------------------------------";
        System.out.println(line);
        System.out.printf("%-35s%-20s%-10s%n","| ФИО","| Должность","| Зарплата |");
        System.out.println(line);
        for (Employee e : staff) {
            System.out.printf("%-35s%-20s%-10s%-10s%n","| " + e.getName(),"| " + e.getPosition(),"| "+ e.getPayment()," |");
        }
        System.out.println(line);
    }

    public static void main(String[] args) {
        ArrayList<DataLoader> arrdl = DataLoader.readInputData("data.json");
        ArrayList<Employee> staff = new ArrayList<Employee>();
        for (DataLoader dl : arrdl) {
            staff.add(dl.createObj());
        }

        for (Employee e : staff) {
            e.setTime(40*4);
            e.calcPayment();
        }

        printResults(staff);
    }
}
