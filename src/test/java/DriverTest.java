import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {

    @Test
    public void calcPayment() {
        Driver myDriver = new Driver(234, "Вася", 15);
        myDriver.setWorktime(100);
        myDriver.calcPayment();
        assertEquals(1500, myDriver.calcPayment());
    }

    @Test
    public void calcPaymentWithBonus() {
        Driver myDriver = new Driver(234, "Вася", 200);
        myDriver.setWorktime(100);
        myDriver.calcPayment();
        assertEquals(23000, myDriver.calcPayment());
    }
}