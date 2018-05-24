import org.junit.Test;

import static org.junit.Assert.*;

public class TeamLeaderTest {

    @Test
    public void calcPaymentByHeading() {
        TeamLeader c1=new TeamLeader(1,"Alex",100,100,5,5,"Project2");
        assertEquals(5*500,c1.calcPaymentByHeading(),0.01);

    }

    @Test
    public void calcPayment() {
        TeamLeader c1=new TeamLeader(1,"Alex",100,100,5,5,"Project2");
        assertEquals(0.05*200000+100*100+5*500,c1.CalcPayment(),0.01);
    }
}