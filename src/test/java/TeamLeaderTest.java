import org.junit.Test;

import static org.junit.Assert.*;

public class TeamLeaderTest {

    @Test
    public void calcPaymentBySubs() {
        TeamLeader myTeamLeader = new TeamLeader(234, "Вася", 100,
                1000, 0.5, 2);
        assertEquals(4000, myTeamLeader.calcPaymentBySubs());
    }

    @Test
    public void calcPayment() {
        TeamLeader myTeamLeader = new TeamLeader(234, "Вася", 50,
                1000, 0.5, 2);
        myTeamLeader.setWorktime(100);
        assertEquals(9500, myTeamLeader.calcPayment());
    }
}