import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {
    Driver tesrDr = new Driver("Анисимова Евгения Сергеевна", 54);

    @Test
    public void calculateSalary() {
        tesrDr.setWorktime(84);
        tesrDr.setRate(500);
        tesrDr.setBusinessTrip(5);
        assertEquals(47000, tesrDr.calculateSalary(), 0.01);
    }

    @Test
    public void calculateSalary1() {
        tesrDr.setWorktime(102);
        tesrDr.setRate(500);
        tesrDr.setBusinessTrip(8);
        assertEquals(59000, tesrDr.calculateSalary(), 0.01);
    }
}