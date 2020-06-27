import org.junit.Test;
import static org.junit.Assert.*;
public class CleanerTest
{
    @Test
    public void calcSalary()
    {
        Cleaner emp = Cleaner.generate(27,"Тест",168,100,"Cleaner");
        assertEquals(16800.0,emp.CalcZP(),0.1);
    }
    @Test
    public void calcSalary1()
    {
        Cleaner emp = Cleaner.generate(27,"Тест",168,0,"Cleaner");
        assertEquals(0.0,emp.CalcZP(),0.1);
    }
    @Test(expected = RuntimeException.class)
    public void calcSalary2() throws RuntimeException
    {
        Cleaner emp = Cleaner.generate(27,"Тест",-20,-150,"Cleaner");
        assertEquals(0.0,emp.CalcZP(),0.1);
    }
}