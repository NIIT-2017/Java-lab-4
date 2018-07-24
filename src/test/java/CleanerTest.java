import static org.junit.Assert.*;

public class CleanerTest {

    @org.junit.Test
    public void calcPay() {
        Cleaner cleaner = new Cleaner(777, "Abc F.D.", 10, 20);
        assertEquals(200, cleaner.calcPay());
    }
}