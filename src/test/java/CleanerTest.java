import org.junit.Test;

import static org.junit.Assert.*;

public class CleanerTest {

    @Test
    public void countPayment() {
        Cleaner cleaner = new Cleaner.Builder().base(20000).worktime(80).build();
        cleaner.countPayment();
        int payment = cleaner.getPayment();
        assertEquals(10000, payment);
    }
}