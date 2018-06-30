import org.junit.Test;

import static org.junit.Assert.*;

public class CleanerTest {
    Cleaner cleaner = new Cleaner(2, "Dolores Oriordan", 155, 0, 200);

    @Test
    public void paymentFromTime() {
        assertEquals(31000.0, cleaner.paymentFromTime(), 0.1);
    }

    @Test
    public void calcPayment() {
        cleaner.setWorkTime(180);
        assertEquals(39600.0, cleaner.calcPayment(), 0.1);
    }
}