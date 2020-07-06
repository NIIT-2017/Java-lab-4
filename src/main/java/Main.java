import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ParseToEmployee parser = new ParseToEmployee("employees.json");
        List<Employee> employees = parser.getEmployeesFromResources();
        for(Employee employee: employees){
            employee.calc();
        }
        String outputFile = "result.txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            String heading = String.format("%3s %35s  %10s\n", "ID", "NAME", "SALARY");
            writer.write(heading);
            System.out.print(heading);
            for(Employee employee: employees){
                String line = String.format("%3d %35s  %10.2f\n", employee.getId(), employee.getName(), employee.getPayment());
                writer.write(line);
                System.out.print(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
