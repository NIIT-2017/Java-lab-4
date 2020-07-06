import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {

    @Test
    public void countPayment() {
        Driver driver = new Driver.Builder().base(20000).worktime(80).extraCharge(5000).build();
        driver.countPayment();
        int payment = driver.getPayment();
        assertEquals(15000, payment);
    }
}