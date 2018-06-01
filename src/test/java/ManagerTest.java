import org.junit.Before;

import static org.junit.Assert.*;


public class ManagerTest {
    Manager manager =new Manager(7,
            "Игнатьев Юстиниан Христофорович",180,250,0, 1, 1390000, "Pro1");


    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void payForProject() {
        assertEquals(13900.0, manager.payForProject());
    }

    @org.junit.Test
    public void calcPayment() {
        assertEquals(13900.0, manager.calcPayment());
    }
}