import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectManagerTest {

    @Test
    public void headcalc() {
        ProjectManager pr = new ProjectManager(1, "Vasya Pupkin", "ProjectManager", 100, "java", 1000000, 0.1, 3, 1000);
        assertEquals(3000, pr.headcalc());
    }

    @Test
    public void calc() {
        ProjectManager pr = new ProjectManager(1, "Vasya Pupkin", "ProjectManager", 100, "java", 1000000, 0.1, 3, 1000);
        assertEquals(103000, pr.calc());
    }
}