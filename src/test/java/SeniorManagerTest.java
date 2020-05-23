import org.junit.Test;

import static org.junit.Assert.*;

public class SeniorManagerTest {

    @Test
    public void countPayment() {
        SeniorManager seniorManager = (SeniorManager) new SeniorManager.Builder().
                rate(1000).
                subordinates(15).
                budget(1000000).
                share(0.1).
                duration(5).build();
        seniorManager.countPayment();
        int payment = seniorManager.getPayment();
        assertEquals(35000, payment);
    }
}