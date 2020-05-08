import org.junit.Test;

import static org.junit.Assert.*;

public class SeniorManagerTest {
    SeniorManager testSM = new SeniorManager("Вершкова Федосья Ярославовна", 57);

    @Test
    public void calculateSalaryForHeading() {
        testSM.setNumberOfPeopleInCompany(66);
        int number = testSM.getNumberOfPeopleInCompany();
        assertEquals(650000, testSM.calculateSalaryForHeading(number), 0.01);
    }

    @Test
    public void calculateSalaryForHeading1() {
        testSM.setNumberOfPeopleInCompany(13);
        int number = testSM.getNumberOfPeopleInCompany();
        float rate = testSM.getRate();
        assertEquals(120000, testSM.calculateSalaryForHeading(number), 0.01);
    }
}
