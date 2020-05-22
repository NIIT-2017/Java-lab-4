import org.junit.Test;

import static org.junit.Assert.*;

public class ProgrammerTest {

    @Test
    public void countPayment() {
        Programmer programmer = new Programmer.Builder().
                base(20000).
                worktime(80).
                budget(1000000).
                duration(10).
                share(0.1).build();
        programmer.countPayment();
        int payment = programmer.getPayment();
        assertEquals(20000, payment);
    }
}