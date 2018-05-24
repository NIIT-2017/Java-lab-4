import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {

    @Test
    public void calcPayment() {
        Driver c1=new Driver(1,"Alex",100.5,200,500);
        assertEquals(20600,c1.CalcPayment(),0.01);
    }
}