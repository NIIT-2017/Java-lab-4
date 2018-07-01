import org.junit.Test;

import static org.junit.Assert.*;

public class CleanerTest {

    @Test
    public void calcPayment() {
        Cleaner clnr = new Cleaner(1, "Valera", 100.5, 200,200);
        assertEquals(20300, clnr.calcPayment(), 0.01);
    }
}