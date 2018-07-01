import org.junit.Test;

import static org.junit.Assert.*;

public class TeamLeaderTest {

    @Test
    public void calcPaymentByHeading() {
        TeamLeader tl = new TeamLeader(1, "Robb", 160, 200, 500, 5, "Project3");
        assertEquals(2500, tl.calcPaymentByHeading(), 0.01);
    }

    @Test
    public void calcPayment() {
        TeamLeader tl = new TeamLeader(1, "Robb", 160, 200, 5, 5, "Project3");
        assertEquals(284500.0, tl.calcPayment(), 0.01);
        }
}