import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TeamLeaderTest {

    HashMap<String, Double> mapProjectsPercent=new HashMap<String, Double>(){{
        put("Internet of things in production",0.0013);
        put("Unmanned control",0.001);
        put("Online store",0.00035);
    }};

    TeamLeader teamLeader=new TeamLeader(456,"Щукина Ольга Сергеевна",28762.7,mapProjectsPercent,7);

    @org.junit.Test
    public void checkGetPersonal() {
        assertEquals(7,teamLeader.getPersonal());
    }

    @org.junit.Test
    public void checkSetPersonal() {
        teamLeader.setPersonal(9);
        assertEquals(9,teamLeader.getPersonal());
    }

    @org.junit.Test
    public void checkCalcHeading() {
        teamLeader.setWorkTime(35);
        assertEquals(2588.709375,teamLeader.calcHeading(9));
    }

    @org.junit.Test
    public void checkCalc() {
        teamLeader.setWorkTime(35);
        assertEquals(17240.888343500003,teamLeader.calc());
    }

    @org.junit.Test
    public void checkToString() {
        assertEquals("TeamLeader",teamLeader.toString());
    }
}