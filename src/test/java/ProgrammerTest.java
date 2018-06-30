import org.junit.Test;

import static org.junit.Assert.*;

public class ProgrammerTest {
    Programmer programmer = new Programmer(3, "Mike Wachowski", 168, 0, "Project1",
            500, 0.04);

    @Test
    public void paymentFromProject() {
        assertEquals(40000.0, programmer.paymentFromProject(), 0.1);
    }

    @Test
    public void paymentFromTime() {
        assertEquals(84000.0, programmer.paymentFromTime(), 0.1);
    }

    @Test
    public void calcPayment() {
        assertEquals(124000.0, programmer.calcPayment(), 0.1);
    }
}