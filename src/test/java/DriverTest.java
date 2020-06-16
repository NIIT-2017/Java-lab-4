import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DriverTest {

    Driver driver=new Driver(2367,"Новикова Оксана Александровна", 21367.9, 3);

    @org.junit.Test
    public void checkGetCountWeekendTripsHours() {
        assertEquals(3,driver.getCountWeekendTripsHours());
    }

    @org.junit.Test
    public void setCountWeekendTripsHours() {
        driver.setCountWeekendTripsHours(7);
        assertEquals(7,driver.getCountWeekendTripsHours());
    }

    @org.junit.Test
    public void checkAllowance() {
        assertEquals(10683.95,driver.allowance(5));
    }

    @org.junit.Test
    public void checkCalc() {
        driver.setWorkTime(25);
        assertEquals(11752.345000000001,driver.calc());
    }

    @org.junit.Test
    public void checkToString() {
        assertEquals("Driver",driver.toString());
    }
}