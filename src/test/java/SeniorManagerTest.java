import org.junit.Test;

import static org.junit.Assert.*;

public class SeniorManagerTest {

    @Test
    public void calcPayment() {
        SeniorManager sm = new SeniorManager(1, "Jaime", 160, 5, 5, "Project3");
        assertEquals(252500.0, sm.calcPayment(),0.01);
    }
}