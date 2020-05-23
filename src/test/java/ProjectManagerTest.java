import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectManagerTest {

    @Test
    public void countPayment() {
        ProjectManager projectManager = (ProjectManager) new ProjectManager.Builder().
                rate(1000).
                subordinates(5).
                budget(1000000).
                share(0.1).
                duration(5).build();
        projectManager.countPayment();
        int payment = projectManager.getPayment();
        assertEquals(25000, payment);
    }
}