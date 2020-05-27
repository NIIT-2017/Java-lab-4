import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagersTest {

    public static Manager testManager = new Manager(106, "testManager");
    public static ProjectManager testProjectManager = new ProjectManager(107, "testProjectManager");
    public static SeniorManager testSeniorManager = new SeniorManager(108, "testSeniorManger");
    public static TeamLead testTeamLead = new TeamLead(105, "testTeamLead", 40);
    public static ProjectItem project1 = new ProjectItem("project1", 10000);
    public static ProjectItem project2 = new ProjectItem("project2", 20000);
    public static ProjectItem project3 = new ProjectItem("project3", 30000);

    @BeforeClass
    public static void start(){
        HR.addStaff(testSeniorManager);
        HR.addStaff(testProjectManager);
        HR.addStaff(testManager);
        HR.addStaff(testTeamLead);
        Accounting.addProject(project1);
        Accounting.addProject(project2);
        Accounting.addProject(project3);
        testManager.setWorktime(100);
        testProjectManager.setWorktime(100);
        testSeniorManager.setWorktime(100);
        testTeamLead.setWorktime(100);
    }

    @Test
    public void getPayment() {
        testSeniorManager.setProject("project3");
        testSeniorManager.setSubordinateStaff(107);
        assertEquals(12960, testSeniorManager.getPayment(), 0.01f);
        testSeniorManager.setSubordinateStaff(105);
        testTeamLead.setProject("project3");
        assertEquals(7795, testSeniorManager.getPayment(), 0.01f);
    }

    @Test
    public void moneyForProject() {
        testProjectManager.setProject("project2");
        assertEquals(6720, testProjectManager.moneyForProjects(), 0.01f);
    }

    @Test
    public void setProject() {
        assertTrue(testManager.setProject("project1"));
        assertFalse(testManager.setProject("project1"));
        assertFalse(testManager.setProject("nonexistentProject"));
    }
}