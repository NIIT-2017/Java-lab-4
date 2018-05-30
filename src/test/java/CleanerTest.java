import org.junit.Test;

import static org.junit.Assert.*;

public class CleanerTest {

    @Test
    public void calcPayment() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "уборщик";
        double base = 200.0d;
        double time = 160.0d;
        Cleaner cl = new Cleaner(id, name, position, base);
        cl.setTime(time);
        cl.calcPayment();
        assertEquals(cl.getPayment(), 32000.0d, 0.00001);
    }

    @Test
    public void calcPaymentFromTime() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "уборщик";
        double base = 200.0d;
        double time = 160.0d;
        Cleaner cl = new Cleaner(id, name, position, base);
        cl.setTime(time);
        assertEquals(cl.calcPaymentFromTime(), 32000.0d, 0.00001);
    }
}