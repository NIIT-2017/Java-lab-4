import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectManagerTest {

    @Test
    public void calc() {
        ProjectManager projectManager = new ProjectManager(1, "Каськов Олег Владимирович", "project2", 8);
        projectManager.calc();
        Double salary = projectManager.getPayment();
        assertEquals(salary.equals(144600.00), true);
    }
}