import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void calc() {
        Manager manager = new Manager(1, "Васильева Ирина Дмитриевна", "project1");
        manager.calc();
        Double salary = manager.getPayment();
        assertEquals(salary.equals(30000.00), true);
    }
}