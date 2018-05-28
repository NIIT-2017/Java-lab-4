import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void getProjectPay() {
        Manager manager = new Manager(1,"Ivanov","Messenger");
        assertEquals(40000,manager.getProjectPay(),0);
    }

    @Test
    public void getProjectName() {
        Manager manager = new Manager(1,"Ivanov","Messenger");
        assertEquals("Messenger", manager.getProjectName());
    }

    @Test
    public void setPayment() {
        Manager manager = new Manager(1,"Ivanov","Messenger");
        manager.setPayment();
        assertEquals(50000,manager.getPayment(),0);
    }
}