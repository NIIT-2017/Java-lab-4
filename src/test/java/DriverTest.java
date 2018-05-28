import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {

    @Test
    public void payCalc() {
        Driver driver = new Driver(1,"Ivanov",100);
        driver.setWorkTime(10);
        assertEquals(1100,driver.PayCalc(),0);
    }
}