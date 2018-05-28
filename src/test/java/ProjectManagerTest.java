import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectManagerTest {

    @Test
    public void getHeadingPay() {
        ProjectManager projectManager = new ProjectManager(1,"Ivanov","Messenger",1);
        assertEquals(3000,projectManager.getHeadingPay(),0);
    }

    @Test
    public void setPayment() {
        ProjectManager projectManager = new ProjectManager(1,"Ivanov","Messenger",1);
        projectManager.setPayment();
        assertEquals(133000,projectManager.getPayment(),0);
    }
}