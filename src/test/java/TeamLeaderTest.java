import org.junit.Test;

import static org.junit.Assert.*;

public class TeamLeaderTest {

    @Test
    public void calc() {
        TeamLeader teamLeader = new TeamLeader(1, "Зуев Никита Романович", 184, 500.0, "project1", 7);
        teamLeader.calc();
        Double salary = teamLeader.getPayment();
        assertEquals(salary.equals(128300.00), true);
    }
}