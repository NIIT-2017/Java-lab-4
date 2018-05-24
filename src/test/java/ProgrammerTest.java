import org.junit.Test;

import static org.junit.Assert.*;

public class ProgrammerTest {

    @Test
    public void calcPayment() {
        Programmer c1=new Programmer(1,"Alex",100,20,5,"Project3");
        assertEquals(50000*0.05+100*20,c1.CalcPayment(),0.01);
    }
}