import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void calcSalary() {
        Manager test = Manager.generate(100,"Test","Manager","progect1",0.5f);
        assertEquals(1000000.0,test.CalcSalary(),0.1);
    }

    @Test
    public void calcSalary1() {
        Manager test = Manager.generate(100,"Test","Manager","progect1",0.0f);
        assertEquals(0.0,test.CalcSalary(),0.1);
    }


}