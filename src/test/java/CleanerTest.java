import static org.junit.Assert.*;

public class CleanerTest {
    @org.junit.Test
    public void calc() {
        Cleaner cleaner = new Cleaner(1,"Павлик Светлана Владимировна", 63, 200.0);
        cleaner.calc();
        Double salary = cleaner.getPayment();
        assertEquals(salary.equals(12600.0), true);
    }
}