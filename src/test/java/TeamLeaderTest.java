import org.junit.Test;

import static org.junit.Assert.*;

public class TeamLeaderTest {
    TeamLeader teamLeader = new TeamLeader(3, "Mark Zukerberg", 198, 0, "Project2",
            600, 0.13, 4, 3000);
    @Test
    public void paymentFromProject() {
        assertEquals(156000.0, teamLeader.paymentFromProject(), 0.1);
    }

    @Test
    public void paymentFromTime() {
        assertEquals(118800.0, teamLeader.paymentFromTime(), 0.1);
    }

    @Test
    public void paymentFromHeading() {
        assertEquals(12000.0, teamLeader.paymentFromHeading(), 0.1);
    }

    @Test
    public void calcPayment() {
        assertEquals(286800.0, teamLeader.calcPayment(), 0.1);
        teamLeader.setEmployeeRating(0.5);
        assertEquals(730800.0, teamLeader.calcPayment(), 0.1);
        teamLeader.setBaseRate(1200);
        assertEquals(849600.0, teamLeader.calcPayment(), 0.1);
    }
}