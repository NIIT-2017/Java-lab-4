import static org.junit.Assert.*;

public class TeamLeaderTest {

    @org.junit.Test
    public void calc() {
        TeamLeader test = new TeamLeader(12, "TEST", 800, "Project1", 3);
        test.setWorktime(30);
        test.calc();
        assertEquals(69000, test.getPayment());

    }
}