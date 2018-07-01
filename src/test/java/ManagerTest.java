import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void calcPaymentByProject() {
        Manager mngr = new Manager(1, "Stannis", 200, 3, "Project3");
        assertEquals(150000.0, mngr.calcPayment(), 0.01);
    }

    @Test
    public void calcPayment() {
        Manager mngr = new Manager(1, "Stannis", 200,3 , "Project3");
        assertEquals(150000.0, mngr.calcPayment(), 0.01);
    }
}