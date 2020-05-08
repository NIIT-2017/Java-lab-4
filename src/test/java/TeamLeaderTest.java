import org.junit.Test;

import static org.junit.Assert.*;

public class TeamLeaderTest {
    TeamLeader testTL = new TeamLeader("Титов Платон Григорьевич", 58);

    @Test
    public void calculateSalaryForHeading() {
        testTL.setNumberOfPeopleInProject(12);
        int number = testTL.getNumberOfPeopleInProject();
        testTL.setOverfulfilmentOfPlan(0);
        assertEquals(150750, testTL.calculateSalaryForHeading(number), 0.01);
    }

    @Test
    public void calculateSalaryForHeading1() {
        testTL.setNumberOfPeopleInProject(8);
        int number = testTL.getNumberOfPeopleInProject();
        testTL.setOverfulfilmentOfPlan(1);
        assertEquals(113750, testTL.calculateSalaryForHeading(number), 0.01);
    }
}