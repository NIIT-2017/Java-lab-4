import org.junit.Test;
import static org.junit.Assert.*;
public class ProjectManagerTest
{
    @Test
    public void calcSalary()
    {
        ProjectManager test = ProjectManager.generate(31,"Test","ProjectManager",
                "Allproject",1.0f,0);
        assertEquals(4500000,test.CalcZP(),1.0);
    }
    @Test
    public void calcSalary1()
    {
        ProjectManager test = ProjectManager.generate(31,"Test","ProjectManager",
                "Allproject",0.0f,5);
        assertEquals(250000,test.CalcZP(),1.0);
    }
}