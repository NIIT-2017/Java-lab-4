import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {
    Manager testM = new Manager("Сафонов Прохор Леонидович", 55);

    @Test
    public void getProportionOfParticipationInProject() {
        assertEquals(192000, testM.getProportionOfParticipationInProject(1200000), 0.01);
    }

    @Test
    public void getProportionOfParticipationInProject1() {
        assertEquals(960000, testM.getProportionOfParticipationInProject(6000000), 0.01);
    }

    @Test
    public void calculateSalaryForTheProject() {
        float months = 12;
        testM.setProjectTermInMonths(months);
        assertEquals(80000, testM.calculateSalaryForTheProject(960000, months), 0.01);
    }

    @Test
    public void calculateSalaryForTheProject1() {
        float months = 6;
        testM.setProjectTermInMonths(months);
        assertEquals(32000, testM.calculateSalaryForTheProject(192000, months), 0.01);
    }
}