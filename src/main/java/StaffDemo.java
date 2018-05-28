import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class StaffDemo{
    public static void main(String[]args){
//        URL staff = System.class.getResource("/staff.txt");
//        File staff = new File("staff.txt");
        InputStream fileEmployees=System.class.getResourceAsStream("/staff.txt");

        Staff NIIT = new Staff(fileEmployees);
        NIIT.setWorkTime(168);
        NIIT.setPayment();

        JFrame frame = new JFrame("Payment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane(NIIT.getPayments());

        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(750, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}


class Staff{
    private ArrayList<Employee> employees;
    private String[] arr;

    Staff(InputStream fileEmployees){
        addEmployees(fileEmployees);
    }

    public void addEmployees(InputStream fileEmployees){
        employees=new ArrayList<Employee>();
        try{
            String string;
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileEmployees));
            while ((string = reader.readLine()) != null){
                arr=string.split(",");
                if (arr[0].equals("Cleaner"))
                    employees.add(new Cleaner(Integer.parseInt(arr[1]),arr[2],Integer.parseInt(arr[3])));
                else if (arr[0].equals("Driver"))
                    employees.add(new Driver(Integer.parseInt(arr[1]),arr[2],Integer.parseInt(arr[3])));
                else if (arr[0].equals("Programmer"))
                    employees.add(new Programmer(Integer.parseInt(arr[1]),arr[2],Integer.parseInt(arr[3]),arr[4]));
                else if (arr[0].equals("Tester"))
                    employees.add(new Tester(Integer.parseInt(arr[1]),arr[2],Integer.parseInt(arr[3]),arr[4]));
                else if (arr[0].equals("TeamLeader"))
                    employees.add(new TeamLeader(Integer.parseInt(arr[1]),arr[2],Integer.parseInt(arr[3]),arr[4],Integer.parseInt(arr[5])));
                else if (arr[0].equals("Manager"))
                    employees.add(new Manager(Integer.parseInt(arr[1]),arr[2],arr[3]));
                else if (arr[0].equals("ProjectManager"))
                    employees.add(new ProjectManager(Integer.parseInt(arr[1]),arr[2],arr[3],Integer.parseInt(arr[4])));
                else if (arr[0].equals("SeniorManager"))
                    employees.add(new SeniorManager(Integer.parseInt(arr[1]),arr[2],arr[3],Integer.parseInt(arr[4])));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setWorkTime(int time){
        for (Employee name:employees) {
            name.setWorkTime(time);
        }
    }

    public void setPayment(){
        for (Employee name:employees) {
            name.setPayment();
        }
    }

    public JTable getPayments(){
        int i=0;
        String[][] arr = new String[employees.size()][3];
        String[] columnNames = {
                "FIO",
                "ID",
                "Payment"
        };
        for (Employee name:employees) {
            arr[i][0]=name.getName();
            arr[i][1]=""+name.getID();
            arr[i++][2]=""+name.getPayment();
        }

        JTable table = new JTable(arr, columnNames);

        return table;
    }
}