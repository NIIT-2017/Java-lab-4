import org.junit.Test;

import static org.junit.Assert.*;

public class TesterTest {

    @Test
    public void calc() {
        Tester tester = new Tester(1, "Fedya Petrov", "Tester", 185, 1000, "java", 500000, 0.04);
        assertEquals(205000, tester.calc());
    }
}