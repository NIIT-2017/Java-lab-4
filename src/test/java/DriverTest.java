import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {
    Driver driver = new Driver(5, "Michael Schumacher", 145, 0, 300);

    @Test
    public void paymentFromTime() {
        assertEquals(43500.0, driver.paymentFromTime(), 0.1);
    }

    @Test
    public void calcPayment() {
        driver.setWorkTime(180);
        assertEquals(64800.0, driver.calcPayment(), 0.1);
    }
}