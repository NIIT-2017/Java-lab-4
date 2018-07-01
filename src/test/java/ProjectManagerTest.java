import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectManagerTest {

    @Test
    public void calcPaymentByHeading() {
        ProjectManager pm = new ProjectManager(1, "Cersei", 160, 5, 5,"Project3");
        assertEquals(252500, pm.calcPayment(),0.01);
    }

    @Test
    public void calcPayment() {
        ProjectManager pm = new ProjectManager(1, "Cersei", 160, 5, 5,"Project3");
        assertEquals(252500, pm.calcPayment(), 0.01);
    }
}