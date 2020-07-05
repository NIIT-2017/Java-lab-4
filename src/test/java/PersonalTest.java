import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonalTest {
    @Test
    public void calcPaymentByRate() {
        Personal pers = new Cleaner(4, "Тест", 80);
        pers.setWorktime(100);
        assertEquals(8000, pers.calcPayment());
    }

}