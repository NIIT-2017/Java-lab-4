import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DriverTest {
    @Test
    public void calcPayment() {
        Driver dr = new Driver(12, "Тест", 100);
        dr.setWorktime(120);
        dr.calcPayment();
        assertEquals(12000, dr.calcPayment());
    }
}