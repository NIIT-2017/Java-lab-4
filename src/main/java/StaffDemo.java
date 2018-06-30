import java.util.List;
import java.util.Random;

public class StaffDemo {
    public static void main(String[] args) {
        StaffReader staffOne = new StaffReader();
        List<Employee> staff = staffOne.addStaffFromFile("src/main/resources/staff.json");
        for (Employee emp : staff) {
            int randTime = new Random().nextInt(30) + 150;
            emp.setWorkTime(randTime);
            emp.setPayment(emp.calcPayment());
        }
        staffOne.printResults();
    }
}
