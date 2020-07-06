import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void calcPaymentByPart() {
        Manager myManager = new ProjectManager(234, "Вася", 1000, 0.5, 2);
        assertEquals(500, myManager.calcPaymentByPart());
    }
}