import org.junit.Test;

import static org.junit.Assert.*;

public class CleanerTest {

    @Test
    public void calc() {
        Cleaner cl = new Cleaner(1, "Zina Petrova", "Cleaner", 120, 500);
        assertEquals(60000, cl.calc());
    }
}