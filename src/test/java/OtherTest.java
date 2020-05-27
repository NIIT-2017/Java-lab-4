import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class OtherTest {

    public static Driver testDriver = new Driver(101, "testDriver", 10);
    public static Cleaner testCleaner = new Cleaner(102, "testCleaner", 10);
    public static Tester testTester = new Tester(103, "testTester", 15);
    public static Programmer testProgrammer = new Programmer(104, "testProgrammer", 20);
    public static TeamLead testTeamLead = new TeamLead(105, "testTeamLead", 40);
    public static Manager testManager = new Manager(106, "testManager");
    public static ProjectManager testProjectManager = new ProjectManager(107, "testProjectManager");
    public static SeniorManager testSeniorManager = new SeniorManager(108, "testSeniorManger");
    ProjectItem project1 = new ProjectItem("project1", 10000);
    ProjectItem project2 = new ProjectItem("project2", 20000);
    ProjectItem project3 = new ProjectItem("project3", 30000);

    @BeforeClass
    public static void start(){
        HR.addStaff(new Programmer(1, "Nameless", 25));
        HR.addStaff(testSeniorManager);
        HR.addStaff(testProjectManager);
        HR.addStaff(testTeamLead);
        HR.addStaff(testManager);
        HR.addStaff(testProgrammer);
        HR.addStaff(testTester);
        HR.addStaff(testDriver);
        HR.addStaff(testCleaner);
    }
    //HR class testing
    @Test
    public void addStaff() {
        assertTrue(HR.addStaff(new Driver(2, "Driver", 10)));
        assertFalse(HR.addStaff(new Tester(2, "Tester", 15)));
    }

    @Test
    public void getEmployee() {
        assertEquals("Nameless", HR.getEmployee(1).getName());
        assertNull(HR.getEmployee(50));
    }

    @Test
    public void isValidStaff() {
        assertFalse(HR.isValidStaff(testSeniorManager, 104));
        assertTrue(HR.isValidStaff(testSeniorManager, 105));
        assertFalse(HR.isValidStaff(testSeniorManager, 106));
        assertFalse(HR.isValidStaff(testSeniorManager, 108));
        assertFalse(HR.isValidStaff(testSeniorManager, 101));
        assertTrue(HR.isValidStaff(testProjectManager, 106));
        assertFalse(HR.isValidStaff(testProjectManager, 104));
        assertFalse(HR.isValidStaff(testProjectManager, 107));
        assertFalse(HR.isValidStaff(testProjectManager, 102));
        assertTrue(HR.isValidStaff(testTeamLead, 104));
        assertTrue(HR.isValidStaff(testTeamLead, 103));
        assertFalse(HR.isValidStaff(testTeamLead, 106));
        assertFalse(HR.isValidStaff(testTeamLead, 105));
        assertFalse(HR.isValidStaff(testTeamLead, 101));
    }
    //Accounting class testing
    @Test
    public void addProject(){
        assertTrue(Accounting.addProject(project3));
        assertFalse(Accounting.addProject(new ProjectItem("project3", 5000)));
    }

    @Test
    public void addToProject(){
        Accounting.addProject(project2);
        assertTrue(Accounting.addToProject(106, "project2"));
        assertFalse(Accounting.addToProject(106, "project2"));
        assertFalse(Accounting.addToProject(102, "project2"));
        assertFalse(Accounting.addToProject(106, new ProjectItem("unregisteredProject", 500).getTitle()));
    }

    @Test
    public void projectCut(){
        Accounting.addProject(project1);
        testTeamLead.setWorktime(100);
        testTeamLead.setProject("project1");
        testProgrammer.setWorktime(100);
        testProgrammer.setProject("project1");
        testTeamLead.setSubordinateStaff(104);
        assertEquals(1650, Accounting.projectCut(105, "project1"), 0.01f);
        assertEquals(1545, Accounting.projectCut(104, "project1"), 0.01f);
    }

    @Test
    public void headCut(){
        assertEquals(0.1f, Accounting.headPremium(107), 0.005f);
        assertEquals(0.1f, Accounting.headPremium(105), 0.005f);
        assertEquals(0.02f, Accounting.headPremium(106), 0.005f);
        assertEquals(0.03f, Accounting.headPremium( 104), 0.005f);
        assertEquals(0.01f, Accounting.headPremium(103), 0.005f);
    }
}