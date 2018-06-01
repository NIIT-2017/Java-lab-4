import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectManagerTest {
    ProjectManager projectManager =new ProjectManager(7,
            "Игнатьев Юстиниан Христофорович",180,250,0, 4, 10000000, 8,5000,"Pro1");
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void payForProject() {
        assertEquals(400000.0,projectManager.payForProject() );
    }

    @Test
    public void payForHeading() {
        assertEquals(40000,projectManager.payForHeading());
    }

    @Test
    public void calcPayment() {
        assertEquals(440000.0,projectManager.calcPayment());
    }
}