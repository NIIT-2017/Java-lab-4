import org.junit.Test;

import static org.junit.Assert.*;

public class SeniorManagerTest {

    @Test
    public void calcPay() {
        SeniorManager seniorManager = new SeniorManager(1, "Test Senior");
        ProjectManager projectManager = new ProjectManager(2, "manager1");
        ProjectManager projectManager2 = new ProjectManager(2, "manager2");
        System.out.println(ProjectManager.countProjManag);
        assertEquals(144000, seniorManager.calcPay());

    }
}