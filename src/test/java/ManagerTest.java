import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void countPayment() {
        Manager manager = new Manager.Builder().budget(1000000).duration(5).share(0.1).build();
        manager.countPayment();
        int payment = manager.getPayment();
        assertEquals(20000, payment);
    }
}