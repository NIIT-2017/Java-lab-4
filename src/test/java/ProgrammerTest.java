import org.junit.Test;

import static org.junit.Assert.*;

public class ProgrammerTest {

    @Test
    public void calc() {
        Programmer programmer = new Programmer(1, "Fedya Petrov", "Programmer", 175, 800, "java", 500000, 0.08);
        assertEquals(180000, programmer.calc());
    }
}