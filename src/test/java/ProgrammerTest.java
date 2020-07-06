import org.junit.Test;
import static org.junit.Assert.*;
public class ProgrammerTest
{
    @Test
    public void calcSalary()
    {
        Programmer test = Programmer.generate(30,"Test","Programmer",0.0f,
                "LEGO",0.0f,0);
        assertEquals(0.0,test.CalcZP(),0.1);
    }
    @Test
    public void calcSalary1()
    {
        Programmer test = Programmer.generate(30,"Test","Programmer",100,
                "LEGO",0.0f,1);
        assertEquals(100.0,test.CalcZP(),0.1);
    }
}