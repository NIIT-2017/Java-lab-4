import org.junit.Test;

import static org.junit.Assert.*;

public class TesterTest {
    Tester tester = new Tester(7, "Jackie Chan", 189, 0, "Project3", 400, 0.03);

    @Test
    public void paymentFromProject() {
        assertEquals(25500.0, tester.paymentFromProject(), 0.1);
    }

    @Test
    public void paymentFromTime() {
        assertEquals(75600.0, tester.paymentFromTime(), 0.1);
    }

    @Test
    public void calcPayment() {
        assertEquals(101100.0, tester.calcPayment(), 0.1);
    }
}