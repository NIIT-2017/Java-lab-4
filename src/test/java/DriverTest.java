import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {

    @Test
    public void calcSalary() {
       Driver emp = Driver.generate(100,"Тест",160,100,"Driver");
        assertEquals(16000.0,emp.CalcSalary(),0.1);
    }

    @Test
    public void calcSalary1() {
        Driver emp = Driver.generate(100,"Тест",84,0,"Driver");
        assertEquals(0.0,emp.CalcSalary(),0.1);
    }

    @Test(expected = RuntimeException.class)
    public void calcSalary2() throws RuntimeException{
        Driver emp = Driver.generate(100,"Тест",-20,-150,"Driver");
        assertEquals(0.0,emp.CalcSalary(),0.1);
    }
}