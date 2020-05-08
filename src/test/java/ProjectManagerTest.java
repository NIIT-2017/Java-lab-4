import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectManagerTest {
    ProjectManager testPM = new ProjectManager("Светланова Нонна Ивановна", 56);

    @Test
    public void calculateSalaryForHeading() {
        testPM.setNumberOfPeopleInProject(12);
        int number = testPM.getNumberOfPeopleInProject();
        assertEquals(198000, testPM.calculateSalaryForHeading(number), 0.01);
    }

    @Test
    public void calculateSalaryForHeading1() {
        testPM.setNumberOfPeopleInProject(7);
        int number = testPM.getNumberOfPeopleInProject();
        assertEquals(108000, testPM.calculateSalaryForHeading(number), 0.01);
    }
}