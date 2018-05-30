import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {

    @Test
    public void calcPayment() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "уборщик";
        double base = 300.0d;
        double time = 160.0d;
        Driver dr = new Driver(id, name, position, base);
        dr.setTime(time);
        dr.calcPayment();
        assertEquals(dr.getPayment(), 48000.0d, 0.00001);
    }

    @Test
    public void calcPaymentFromTime() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "уборщик";
        double base = 300.0d;
        double time = 160.0d;
        Driver dr = new Driver(id, name, position, base);
        dr.setTime(time);
        assertEquals(dr.calcPaymentFromTime(), 48000.0d, 0.00001);
    }
}