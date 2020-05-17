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

    @Test
    public void getProportionOfParticipationInProject() {
        float budget = 1600000;
        assertEquals(32000, testTL.getProportionOfParticipationInProject(budget), 0.01);
    }

    @Test
    public void calculateSalaryForTheProject() {
        testTL.setProjectTermInMonths(8);
        float months = testTL.getprojectTermInMonths();
        float budget = 1600000;
        float  proportionOfParticipationInProject = testTL.getProportionOfParticipationInProject(budget);
        assertEquals(4000, testTL.calculateSalaryForTheProject(32000, months), 0.01);
    }

    @Test
    public void calculateSalaryForTheProject1() {
        testTL.setProjectTermInMonths(10);
        float months = testTL.getprojectTermInMonths();
        float budget = 5550000;
        float  proportionOfParticipationInProject = testTL.getProportionOfParticipationInProject(budget);
        assertEquals(11100, testTL.calculateSalaryForTheProject(111000, months), 0.01);
    }

    @Test
    public void calculateSalary() {
        testTL.setWorktime(168);
        testTL.setRate(950);
        testTL.setRateHeading(5000);
        testTL.setOverfulfilmentOfPlan(1);
        testTL.calculateSalaryForWorkedTime();
        testTL.setProjectTermInMonths(8);
        float months = testTL.getprojectTermInMonths();
        testTL.calculateSalaryForHeading(8);
        float budget = 1600000;
        float  proportionOfParticipationInProject = testTL.getProportionOfParticipationInProject(budget);
        testTL.calculateSalaryForTheProject(proportionOfParticipationInProject, months);
        assertEquals(218600, testTL.calculateSalary(), 0.01);
    }

    @Test
    public void calculateSalary1() {
        testTL.setWorktime(90);
        testTL.setRate(950);
        testTL.setRateHeading(5000);
        testTL.setOverfulfilmentOfPlan(0);
        testTL.calculateSalaryForWorkedTime();
        testTL.setProjectTermInMonths(10);
        float months = testTL.getprojectTermInMonths();
        testTL.calculateSalaryForHeading(13);
        float budget = 555000;
        float  proportionOfParticipationInProject = testTL.getProportionOfParticipationInProject(budget);
        testTL.calculateSalaryForTheProject(proportionOfParticipationInProject, months);
        assertEquals(136610, testTL.calculateSalary(), 0.01);

    }

}