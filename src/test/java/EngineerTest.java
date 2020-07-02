import org.junit.Test;

import static org.junit.Assert.*;

public class EngineerTest {

    @Test
    public void calcPaymentByPart() {
        Engineer myEngineer = new Programmer(234, "Вася", 15, 1000, 0.5);
        assertEquals(500, myEngineer.calcPaymentByPart());
    }

    @Test
    public void calcPaymentByRate() {
        Engineer myEngineer = new Programmer(234, "Вася", 15, 1000, 0.5);
        myEngineer.setWorktime(100);
        assertEquals(1500, myEngineer.calcPaymentByRate());
    }

    @Test
    public void calcPayment() {
        Engineer myEngineer = new Programmer(234, "Вася", 15, 1000, 0.5);
        myEngineer.setWorktime(100);
        assertEquals(2000, myEngineer.calcPayment());
    }
}