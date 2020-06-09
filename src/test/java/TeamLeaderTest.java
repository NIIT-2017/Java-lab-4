import org.junit.Test;

import static org.junit.Assert.*;

public class TeamLeaderTest {

    @Test
    public void calcSalary() {
        TeamLeader test = TeamLeader.generate(100,"Test","TeamLeader",100,
                "Allprogect",0.0f,160,3);
        assertEquals(166000.0,test.CalcSalary(),0.1);
    }

    @Test
    public void calcSalary1() {
        TeamLeader test = TeamLeader.generate(100,"Test","TeamLeader",0,
                "Allprogect",0.0f,0,0);
        assertEquals(0.0,test.CalcSalary(),0.1);
    }
}