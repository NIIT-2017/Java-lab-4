import org.junit.Test;

import static org.junit.Assert.*;

public class ProgrammerTest {

    @Test
    public void calcPayment() {
        Programmer prgr = new Programmer(1, "Tirion", 160,25,5, "Project3");
        assertEquals(254000, prgr.calcPayment(), 0.01);
    }
}