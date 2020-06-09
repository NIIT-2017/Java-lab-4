import org.junit.Test;

import static org.junit.Assert.*;

public class ProgrammerTest {

    @Test
    public void calcSalary() {
        Programmer test = Programmer.generate(100,"Test","Programmer",0.0f,
                "progect1",0.0f,0);
        assertEquals(0.0,test.CalcSalary(),0.1);
    }

    @Test
    public void calcSalary1() {
        Programmer test = Programmer.generate(100,"Test","Programmer",100,
                "progect1",0.0f,1);
        assertEquals(100.0,test.CalcSalary(),0.1);
    }

}