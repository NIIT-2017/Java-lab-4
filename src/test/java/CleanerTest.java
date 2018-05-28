import org.junit.Test;

import static org.junit.Assert.*;

public class CleanerTest {

    @Test
    public void payCalc() {
        Cleaner cleaner = new Cleaner(1,"Ivanov",100);
        cleaner.setWorkTime(10);
        assertEquals(1000,cleaner.PayCalc(),0);
    }
}