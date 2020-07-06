import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectManagerTest {

    @Test
    public void calcPaymentBySubs() {
        ProjectManager myProjectManager = new ProjectManager(234, "Вася", 1000,
                0.5, 2);
        assertEquals(4000, myProjectManager.calcPaymentBySubs());
    }

    @Test
    public void calcPayment() {
        ProjectManager myProjectManager = new ProjectManager(234, "Вася", 1000,
                0.5, 2);
        assertEquals(4500, myProjectManager.calcPayment());
    }
}