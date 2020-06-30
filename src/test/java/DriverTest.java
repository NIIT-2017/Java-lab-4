import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {
    @Test
    public void calc() {
        Driver driver = new Driver(1, "Иванов Иван Иванович", 184, 300.0, DriverLicenseCategory.D);
        driver.calc();
        Double salary = driver.getPayment();
        assertEquals(salary.equals(57960.00), true);
    }
}