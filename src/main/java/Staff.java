import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
class Staff
{
    private ArrayList<Employee> emp = new ArrayList<>();
    public Staff()
    {
        try
        {
            URL resource = getClass().getResource("Employee.json"); // lucshe po url ishet, srazu norm
            File file = Paths.get(resource.toURI()).toFile();
            String content = FileUtils.readFileToString(file, "utf-8");
            JSONArray employees = new JSONArray(content);
            for (int i = 0; i < employees.length(); i++)
            {
                JSONObject employee = employees.getJSONObject(i);
                switch (employee.getString("position"))
                {
                    case "Cleaner":
                        emp.add(Cleaner.generate(employee.getInt("id"), employee.getString("name"),
                                employee.getInt("worktime"), employee.getInt("base"), "Cleaner"));
                        break;
                    case "Driver":
                        emp.add(Driver.generate(employee.getInt("id"), employee.getString("name"),
                                employee.getInt("worktime"), employee.getInt("base"), "Driver"));
                        break;
                    case "Programmer":
                        emp.add(Programmer.generate(employee.getInt("id"), employee.getString("name"),
                                "Programmer",
                                employee.getFloat("base"), employee.getString("project"),
                                employee.getFloat("share"), employee.getInt("worktime")));
                        break;
                    case "Tester":
                        emp.add(Tester.generate(employee.getInt("id"), employee.getString("name"), "Tester",
                                employee.getInt("base"), employee.getString("project"),
                                employee.getFloat("share"), employee.getInt("worktime")));
                        break;
                    case "Manager":
                        emp.add(Manager.generate(employee.getInt("id"), employee.getString("name"), "Manager",
                                employee.getString("project"), employee.getFloat("share")));
                        break;
                    case "ProjectManager":
                        emp.add(ProjectManager.generate(employee.getInt("id"), employee.getString("name"),
                                "ProjectManager",
                                employee.getString("project"), employee.getFloat("share")));
                        break;
                    case "SeniorManager":
                        emp.add(SeniorManager.generate(employee.getInt("id"), employee.getString("name"),
                                "SeniorManger",
                                employee.getString("project"), employee.getFloat("share")));
                        break;
                    default:
                        emp.add(TeamLeader.generate(employee.getInt("id"), employee.getString("name"),
                                "TeamLeader", employee.getFloat("base"), employee.getString("project"),
                                employee.getInt("share"), employee.getInt("worktime"), employee.getInt("people")));
                        break;
                }
            }
        }
        catch (URISyntaxException | IOException e)
        {
            e.printStackTrace();
        }
    }
    public void calcPayments()
    {
        for (Employee emp : emp)
            emp.CalcZP();
    }
    public void outputStuff(PrintStream ps)
    {
        String format1 = "%1$-4s|%2$-32s|%3$-15s|%4$-5s\n"; // check worktime
        ps.format(format1,"ID", "NAME","POSITION","PAYMENT");
        for (Employee emp : this.emp)
        {
            ps.format(format1, emp.getId(), emp.getName(), emp.getPosition(), emp.getPayment());
        }
    }
}