import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CleanerTest {
    Cleaner cleaner=new Cleaner(34,"Полякова Аза Глебовна",140,100,0);


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calcPayment() {
        assertEquals(18200.0, cleaner.calcPayment());
    }

    @Test
    public void payForHours() {
        assertEquals(18200.0,cleaner.payForHours());
    }
}