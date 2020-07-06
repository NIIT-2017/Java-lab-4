import static org.junit.Assert.*;

public class CleanerTest {
    Cleaner testCl = new Cleaner("Никифорова Прасковья Платоновна", 53);

    @org.junit.Test
    public void calculateSalary() {
        testCl.setWorktime(100);
        testCl.setRate(400);
        assertEquals(40000, testCl.calculateSalary(), 0.01);
    }

    @org.junit.Test
    public void calculateSalary1() {
        testCl.setWorktime(63);
        testCl.setRate(500);
        assertEquals(31500, testCl.calculateSalary(), 0.01);
    }
}