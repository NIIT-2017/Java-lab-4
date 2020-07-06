import org.junit.Test;

import static org.junit.Assert.*;

public class ProgrammerTest {

    @Test
    public void calc() {
        Programmer programmer = new Programmer(1, "Рыбаков Захар Васильевич", 184, 500.0, "project1");
        programmer.calc();
        Double salary = programmer.getPayment();
        assertEquals(salary.equals(102000.00), true);
    }
}