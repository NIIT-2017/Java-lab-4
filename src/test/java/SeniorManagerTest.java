import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeniorManagerTest {
    SeniorManager seniorManager =new SeniorManager(7,
            "Игнатьев Юстиниан Христофорович",180,250,0, 2, 1000000, 5,3000,"Pro1");

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void payForProject() {

        assertEquals(20000.0,seniorManager.payForProject());
    }

    @Test
    public void payForHeading() {
        assertEquals(15000,seniorManager.payForHeading());
    }

    @Test
    public void calcPayment() {
        assertEquals(35000.0,seniorManager.calcPayment());
    }
}