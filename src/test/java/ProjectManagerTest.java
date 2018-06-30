import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectManagerTest {
    ProjectManager projectManager = new ProjectManager(10, "Timothy Cook", 0, "Project2",
            0.2, 3, 3500);

    @Test
    public void paymentFromProject() {
        assertEquals(240000.0, projectManager.paymentFromProject(), 0.1);
    }

    @Test
    public void paymentFromHeading() {
        assertEquals(10500.0, projectManager.paymentFromHeading(), 0.1);
    }

    @Test
    public void calcPayment() {
        projectManager.setEmployeeNum(20);
        assertEquals(310000.0, projectManager.calcPayment(), 0.1);
        projectManager.setProject("Project3");
        assertEquals(240000.0, projectManager.calcPayment(), 0.1);
        projectManager.setPaymentForOneEmp(50000);
        assertEquals(1170000.0, projectManager.calcPayment(), 0.1);

    }
}