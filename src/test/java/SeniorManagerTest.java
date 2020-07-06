import org.junit.Test;

import static org.junit.Assert.*;

public class SeniorManagerTest {

    @Test
    public void calc() {
        SeniorManager seniorManager = new SeniorManager(1, "Шадрин Евгений Евгеньевич", 33);
        seniorManager.calc();
        Double salary = seniorManager.getPayment();
        assertEquals(salary.equals(243000.00), true);
    }
}