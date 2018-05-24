import org.junit.Test;

import static org.junit.Assert.*;

public class TesterTest {

    @Test
    public void calcPayment() {
        Tester c1=new Tester(1,"Alex",100,100,5,"Project2");
        assertEquals(0.05*200000+100*100,c1.CalcPayment(),0.01);
    }
}