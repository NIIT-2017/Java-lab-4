import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamLeaderTest {
    TeamLeader teamLeader =new TeamLeader(7,
            "Игнатьев Юстиниан Христофорович",180,550,0, 3, 1250000, 7,5000,"Pro1");


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void payForProject() {
        assertEquals(37500.0,teamLeader.payForProject());

    }

    @Test
    public void payForHours() {
        assertEquals(99000.0, teamLeader.payForHours());
    }

    @Test
    public void calcPayment() {
        assertEquals(171500.0, teamLeader.calcPayment());
    }

    @Test
    public void payForHeading() {
        assertEquals(35000, teamLeader.payForHeading());
    }
}