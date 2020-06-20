import Employees.Employee;
import Employees.Manager;
import Employees.Programmer;
import org.junit.Test;
import static org.junit.Assert.*;
public class ManagerTests {
    @Test
    public void ManagerAddSubordinateTest() throws Exception
    {
        Manager manager=CreatorForTests.createManager();
        Employee employee=CreatorForTests.createEngineer(Programmer.class,400);
        CreatorForTests.addSubordinatesToManager(manager,2);
        manager.addSubordinate(employee);
        CreatorForTests.addSubordinatesToManager(manager,2);
        assertEquals(employee,manager.getSubordinateById(employee.getId()));
    }
    @Test
    public void ManagerDeleteSubordinateTest() throws Exception
    {
        Manager manager=CreatorForTests.createManager();
        Employee employee=CreatorForTests.createEngineer(Programmer.class,400);
        CreatorForTests.addSubordinatesToManager(manager,2);
        manager.addSubordinate(employee);
        CreatorForTests.addSubordinatesToManager(manager,2);
        manager.removeEmployee(employee);
        assertEquals(null,manager.getSubordinateById(employee.getId()));
        assertEquals(null,employee.getManager());
    }
}
