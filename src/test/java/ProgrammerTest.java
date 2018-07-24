import org.junit.Test;

import static org.junit.Assert.*;

public class ProgrammerTest {

    @Test
    public void calcPay() {
        Programmer programmer = new Programmer(123, "Test", 11, 11);
        assertEquals(49121, programmer.calcPay());
    }
}