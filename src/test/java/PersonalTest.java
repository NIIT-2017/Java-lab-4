import org.junit.Test;

import static org.junit.Assert.*;

public class PersonalTest {

    @Test
    public void calcPaymentByRate() {
        Personal myPersonal = new Cleaner(234, "Вася", 15);
        myPersonal.setWorktime(100);
        assertEquals(1500, myPersonal.calcPaymentByRate());
    }

    @Test
    public void calcPayment() {
        Personal myPersonal = new Cleaner(234, "Вася", 15);
        myPersonal.setWorktime(100);
        assertEquals(1500, myPersonal.calcPayment());
    }
}