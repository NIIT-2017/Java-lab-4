import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {

    @Test
    public void calcPayment() {
        Driver drvr = new Driver(1, "Stanislav", 120, 200, 200);
        assertEquals(24200, drvr.calcPayment(), 0.01);
    }
}