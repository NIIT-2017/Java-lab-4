import org.junit.Test;

import static org.junit.Assert.*;

public class TesterTest {

    @Test
    public void calcPayment() {
        Tester tst = new Tester(1, "Aria", 160, 100, 5, "Project3");
        assertEquals(266000, tst.calcPayment(), 0.01);
    }
}