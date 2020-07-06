import org.junit.Test;

import static org.junit.Assert.*;

public class TesterTest {

    @Test
    public void countPayment() {
        Tester tester = new Tester.Builder().
                base(20000).
                worktime(80).
                budget(1000000).
                duration(10).
                share(0.1).build();
        tester.countPayment();
        int payment = tester.getPayment();
        assertEquals(20000, payment);
    }
}