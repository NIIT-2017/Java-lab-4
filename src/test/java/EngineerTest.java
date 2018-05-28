import org.junit.Test;

import static org.junit.Assert.*;

public class EngineerTest {

    @Test
    public void getProjectPay() {
        Programmer programmer = new Programmer(1,"Ivanov",100,"Messenger");
        assertEquals(20000,programmer.getProjectPay(),0);
    }

    @Test
    public void payCalc() {
        Programmer programmer = new Programmer(1,"Ivanov",100,"Messenger");
        programmer.setWorkTime(10);
        assertEquals(1000,programmer.PayCalc(),0);
    }

    @Test
    public void getProjectName() {
        Programmer programmer = new Programmer(1,"Ivanov",100,"Messenger");
        assertEquals("Messenger",programmer.getProjectName());
    }

    @Test
    public void setPayment() {
        Programmer programmer = new Programmer(1,"Ivanov",100,"Messenger");
        programmer.setWorkTime(100);
        programmer.setPayment();
        assertEquals(30000,programmer.getPayment(),0);
    }
}