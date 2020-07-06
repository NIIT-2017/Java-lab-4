import Employees.Employee;
import Employees.Engineer;
import Employees.JsonStreamer;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import static org.junit.Assert.*;
public class JsonStreamerTests {
    @Test
    public void parseEmployeeTest() throws Exception
    {
        String className="Employees.Engineer";
        String employeeName="Kostas";
        String employeeSurname="Gulbrandson";
        long workTime=583;
        long salaryForHour=48;
        String jsonString="{\"class\": \""+className+"\",\n" +
                "      \"id\": 5,\n" +
                "      \"name\": \""+employeeName+"\",\n" +
                "      \"surname\": \""+employeeSurname+"\",\n" +
                "      \"workTime\": "+workTime+",\n" +
                "      \"salaryForHour\": "+salaryForHour+",\n" +
                "      \"managerId\": -1}";
        JSONParser parser = new JSONParser();
        JSONObject jsonObjectEngineer=(JSONObject)parser.parse(jsonString);
        Engineer engineer= (Engineer) JsonStreamer.readEmployeeFromJson(jsonObjectEngineer,null);
        assertEquals(className,engineer.getClass().getName());
        assertEquals(employeeName,engineer.getName());
        assertEquals(employeeSurname,engineer.getSurname());
        assertEquals(workTime,engineer.getWorkTime());
        assertEquals(salaryForHour,engineer.getSalaryForHour());
    }
}
