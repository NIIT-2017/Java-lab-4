import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {

    @Test
    public void calc() {
        Driver driver = new Driver(1, "Petya Petrov", "Driver", 100, 500);
        assertEquals(50000, driver.calc());
    }

    @Test
    public void calc1() {
        Driver driver = new Driver(1, "Petya Petrov", "Driver", 170, 500);
        assertEquals(88000, driver.calc());
    }
}