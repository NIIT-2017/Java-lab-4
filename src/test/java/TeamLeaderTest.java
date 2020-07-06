import org.junit.Test;
import static org.junit.Assert.*;
public class TeamLeaderTest
{
    @Test
    public void calcSalary()
    {
        TeamLeader test = TeamLeader.generate(32,"Test","TeamLeader",100,
                "Allproject",0.0f,160,3);
        assertEquals(166000.0,test.CalcZP(),0.1);
    }
    @Test
    public void calcSalary1()
    {
        TeamLeader test = TeamLeader.generate(32,"Test","TeamLeader",0,
                "Allproject",0.0f,0,0);
        assertEquals(0.0,test.CalcZP(),0.1);
    }
}