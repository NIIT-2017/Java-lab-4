import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ITGroupTest {

    public static Tester testTester = new Tester(103, "testTester", 15);
    public static Programmer testProgrammer = new Programmer(104, "testProgrammer", 20);
    public static TeamLead testTeamLead = new TeamLead(105, "testTeamLead", 40);
    public static ProjectItem project1 = new ProjectItem("project1", 10000);
    public static ProjectItem project2 = new ProjectItem("project2", 20000);

    @BeforeClass
    public static void start(){
        HR.addStaff(testTeamLead);
        HR.addStaff(testProgrammer);
        HR.addStaff(testTester);
        Accounting.addProject(project1);
        Accounting.addProject(project2);
        testTester.setWorktime(100);
        testTester.setProject("project1");
        testProgrammer.setWorktime(100);
        testProgrammer.setProject("project1");
        testTeamLead.setWorktime(100);
        testTeamLead.setProject("project1");
        testTeamLead.setSubordinateStaff(103);
        testTeamLead.setSubordinateStaff(104);
    }

    @Test

    public void T4_getPayment() {
        assertEquals(2510, testTester.getPayment(), 0.1f);
        assertEquals(3230, testProgrammer.getPayment(), 0.1f);
        assertEquals(12207, testTeamLead.getPayment(), 0.1f);
    }

    @Test
    public void T1_moneyForWorktime() {
        assertEquals(1500, testTester.moneyForWorktime(), 0.1f);
        assertEquals(2200, testProgrammer.moneyForWorktime(), 0.1f);
        assertEquals(4400, testTeamLead.moneyForWorktime(), 0.1f);
    }

    @Test
    public void T2_moneyForProjects(){
        assertEquals(1010, testTester.moneyForProjects(), 0.1f);
        assertEquals(1030, testProgrammer.moneyForProjects(), 0.1f);
        assertEquals(1100, testTeamLead.moneyForProjects(), 0.1f);
        testTeamLead.setProject("project2");
        assertEquals(7700, testTeamLead.moneyForProjects(), 0.1f);
    }

    @Test
    public void T3_moneyForHeading(){
        assertEquals(104, testTeamLead.moneyForHeading(), 0.1f);
        Programmer newProgrammer = new Programmer(110, "addProgrammer", 20);
        HR.addStaff(newProgrammer);
        testTeamLead.setSubordinateStaff(110);
        assertEquals(107, testTeamLead.moneyForHeading(), 0.1f);
    }
}