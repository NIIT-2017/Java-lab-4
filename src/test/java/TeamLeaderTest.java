import org.junit.Test;

import static org.junit.Assert.*;

public class TeamLeaderTest {

    @Test
    public void headcalc() {
        TeamLeader teamLeader = new TeamLeader(1, "Vasya Pupkin", "TeamLeader", 100, 1000, "java", 500000, 0.1, 6, 1500);
        assertEquals(9000, teamLeader.headcalc());
    }

    @Test
    public void calc() {
        TeamLeader teamLeader = new TeamLeader(1, "Vasya Pupkin", "TeamLeader", 100, 1000, "java", 500000, 0.1, 6, 1500);
        assertEquals(159000, teamLeader.calc());
    }
}