import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {
    Manager manager = new Manager(8, "Jordan Belfort", 0, "Project1", 0.05);

    @Test
    public void paymentFromProject() {
        assertEquals(50000.0, manager.paymentFromProject(), 0.1);
    }

    @Test
    public void calcPayment() {
        manager.setProject("Project3");
        assertEquals(42500.0, manager.calcPayment(), 0.1);
    }
}