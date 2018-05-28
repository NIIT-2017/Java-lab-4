import org.junit.Test;

import static org.junit.Assert.*;

public class SeniorManagerTest {

    @Test
    public void setPayment() {
        SeniorManager seniorManager=new SeniorManager(1,"Ivanov","All",1);
        seniorManager.setPayment();
        assertEquals(753000,seniorManager.getPayment(),0);
    }
}