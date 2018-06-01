import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {
    Driver driver=new Driver(32, "Рыбаков Панкрат Антонинович", 143, 200,0);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calcPayment() {
        assertEquals(28600.0, driver.calcPayment());
    }

    @Test
    public void payForHours() {
        assertEquals(28600.0, driver.payForHours());
    }
}