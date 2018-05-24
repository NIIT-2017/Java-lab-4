import static org.junit.Assert.*;

public class CleanerTest {

    @org.junit.Test
    public void calcPayment() {
        Cleaner c1=new Cleaner(1,"Alex",100.5,200,500);
        assertEquals(20600,c1.CalcPayment(),0.01);
    }
}