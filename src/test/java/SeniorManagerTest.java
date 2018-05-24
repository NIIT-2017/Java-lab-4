import org.junit.Test;

import static org.junit.Assert.*;

public class SeniorManagerTest {

    @Test
    public void calcPayment() {
        SeniorManager c1=new SeniorManager(1,"Alex",100,5,5,"Project2");
        assertEquals(0.05*200000+5*500,c1.CalcPayment(),0.01);
    }
}