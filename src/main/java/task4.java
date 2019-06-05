import java.util.ArrayList;

public class task4 {
    public static void main (String arg[]){
        ArrayList<Employee> employees = new ArrayList();
        employees = ReadStaff.readJsonFile("staff.json");
        for(Employee emp : employees){
            emp.setWorktime(41);
            emp.Calc();
            System.out.println("id: "+emp.getId()+" "+emp.getFio()+" payment: "+emp.getPayment() );
        }
    }
}
