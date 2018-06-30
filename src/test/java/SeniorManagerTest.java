import org.junit.Test;

import static org.junit.Assert.*;

public class SeniorManagerTest {
    SeniorManager seniorManager = new SeniorManager(1, "Steven Jobs", 0, "All", 0.1,
            12, 5000, 184, 800);

    @Test
    public void paymentFromProject() {
        assertEquals(305000.0, seniorManager.paymentFromProject(), 0.1);
        seniorManager.setProject("Project1");
        seniorManager.setEmployeeRating(0.5);
        assertEquals(500000, seniorManager.paymentFromProject(), 0.1);
    }

    @Test
    public void paymentFromTime() {
        assertEquals(147200.0, seniorManager.paymentFromTime(), 0.1);
        seniorManager.setBaseRate(2500);
        seniorManager.setWorkTime(200);
        assertEquals(500000, seniorManager.paymentFromTime(), 0.1);
    }

    @Test
    public void paymentFromHeading() {
        assertEquals(60000.0, seniorManager.paymentFromHeading(), 0.1);
        seniorManager.setPaymentForOneEmp(8000);
        seniorManager.setEmployeeNum(50);
        assertEquals(400000, seniorManager.paymentFromHeading(), 0.1);
    }

    @Test
    public void calcPayment() {
        assertEquals(512200.0, seniorManager.calcPayment(), 0.1);
    }
}