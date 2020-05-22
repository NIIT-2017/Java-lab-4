import org.junit.Test;

import static org.junit.Assert.*;

public class TeamLeaderTest {

    @Test
    public void countPayment() {
        TeamLeader teamLeader = (TeamLeader) new TeamLeader.Builder().
                rate(1000).
                subordinates(5).
                base(20000).
                worktime(80).
                budget(1000000).
                duration(10).
                share(0.1).build();
        teamLeader.countPayment();
        int payment = teamLeader.getPayment();
        assertEquals(25000, payment);
    }
}