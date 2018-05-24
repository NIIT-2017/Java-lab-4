import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void calcPaymentByProject() {
        Manager c1=new Manager(1,"Alex",100,1,"Project2");
        assertEquals(200000*0.01,c1.CalcPayment(),0.01);
    }

    @Test
    public void calcPayment() {
        Manager c1=new Manager(1,"Alex",100,3,"Project3");
        assertEquals(50000*0.03,c1.CalcPayment(),0.01);
    }
}