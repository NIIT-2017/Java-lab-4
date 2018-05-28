import org.junit.Test;

import static org.junit.Assert.*;

public class TeamLeaderTest {

    @Test
    public void getHeadingPay() {
        TeamLeader teamLeader=new TeamLeader(1,"Ivanov",100,"Messenger",1);
        assertEquals(3000,teamLeader.getHeadingPay(),0);
    }

    @Test
    public void setPayment() {
        TeamLeader teamLeader=new TeamLeader(1,"Ivanov",100,"Messenger",1);
        teamLeader.setWorkTime(100);
        teamLeader.setPayment();
        assertEquals(33000,teamLeader.getPayment(),0);
    }
}