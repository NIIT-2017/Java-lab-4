import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestsLab4 {

    Creation creation = new Creation();
    Info info;

    @Before
    public void before() {
        creation.projectCreation();
        info = creation.info;
        //  info.calculatePayment();
    }

    @Test
    public void testСalculatePaymentWorkTime() {
        info.allProjects.get(2).getEmployee().get(0).calculatePayment(info.allProjects.get(2).getCost());
        assertEquals(24000, info.allProjects.get(2).getEmployee().get(0).getPayment());
    }

    @Test
    public void testCalculateProjectPayment () {
        info.allProjects.get(0).getEmployee().get(0).calculatePayment(info.allProjects.get(0).getCost());
        assertEquals(15000, info.allProjects.get(0).getEmployee().get(0).getPayment());
    }

    @Test
    public void testCalculatePaymentEngineer () {
        info.allProjects.get(0).getEmployee().get(1).calculatePayment(info.allProjects.get(0).getCost());
        assertEquals(85400, info.allProjects.get(0).getEmployee().get(1).getPayment());
    }

    @Test
    public void testCalculateProjectManagerPayment () {
        info.allProjects.get(1).getEmployee().get(4).calculatePayment(info.allProjects.get(1).getCost());
        assertEquals(60000, info.allProjects.get(1).getEmployee().get(4).getPayment());
    }

}
