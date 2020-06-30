import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TesterTest {

    @Test
    public void calc() {
        Tester tester = new Tester(1, "Большакова Любовь Платоновна", 184, 400.0, "project1");
        tester.calc();
        Double salary = tester.getPayment();
        assertEquals(salary.equals(83600.00), true);
    }
}