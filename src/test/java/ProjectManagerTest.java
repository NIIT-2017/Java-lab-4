import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectManagerTest {

    @Test
    public void calcPaymentByProject() {
        ProjectManager c1=new ProjectManager(1,"Alex",100,5,5,"Project3");
        assertEquals(0.05*50000,c1.calcPaymentByProject(),0.01);
    }

    @Test
    public void calcPaymentByHeading() {
        ProjectManager c1=new ProjectManager(1,"Alex",100,5,5,"Project3");
        assertEquals(5*500,c1.calcPaymentByHeading(),0.01);
    }

    @Test
    public void calcPayment() {
        ProjectManager c1=new ProjectManager(1,"Alex",100,5,5,"Project3");
        assertEquals(0.05*50000+5*500,c1.CalcPayment(),0.01);
    }
}