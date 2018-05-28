import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {


    @Test
    public void getPayment() {
        Employee employee = new Cleaner(1,"Ivanov",100);
        employee.setWorkTime(10);
        employee.setPayment();
        assertEquals(1000,employee.getPayment(),0);
    }

    @Test
    public void setWorkTime() {
        Employee employee = new Cleaner(1,"Ivanov",100);
        employee.setWorkTime(5);
        employee.setPayment();
        assertEquals(500,employee.getPayment(),0);
    }

    @Test
    public void getID() {
        Employee employee = new Cleaner(1,"Ivanov",100);
        assertEquals(1,employee.getID(),0);
    }

    @Test
    public void getName() {
        Employee employee = new Cleaner(1,"Ivanov",100);
        assertEquals("Ivanov",employee.getName());
    }
}