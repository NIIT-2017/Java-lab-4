package StaffDemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProjectTest {
    private Project project;
    private ArrayList<OfficePlankton> officePlanktons;
    private ProjectManager projectManager;
    private TeamLeader teamLeader;
    @Before
    public void setUp() throws Exception {
        project = new Project("Project", 100000);
        officePlanktons = new ArrayList<OfficePlankton>();
        projectManager = new ProjectManager("PMsurname", "PMname", "PMsecondname");
        teamLeader = new TeamLeader("TMsurname", "TMname", "TMsecondname");
        for (int i = 0; i < 5; i++) {
            officePlanktons.add(new Programmer("Psurname" + i, "Pname" + i, "Psecondname" + i));
        }
        for (int i = 0; i < 5; i++) {
            officePlanktons.add(new Tester("Tsurname" + i, "Tname" + i, "Tsecondname" + i));
        }
        for (int i = 0; i < 5; i++) {
            officePlanktons.add(new Manager("Msurname" + i, "Mname" + i, "Msecondname" + i));
        }
    }

    @Test
    public void allotMoney() {
        assertEquals(1000,project.allotMoney(1000),0.00000001);
    }

    @Test
    public void allotMoneynegative() {
        assertEquals(0,project.allotMoney(-1000),0.00000001);
    }

    @Test
    public void allotMoneyNotEnough() {
        assertEquals(0,project.allotMoney(1000000),0.00000001);
    }

    @Test
    public void addOfficeplankton() {
        assertNull(project.getEmployee());
        project.addOfficeplankton(officePlanktons);
        assertNotNull(project.getEmployee());
    }

    @Test
    public void addOfficeplanktonNull() {
        officePlanktons = null;
        assertNull(project.getEmployee());
        project.addOfficeplankton(officePlanktons);
        assertNull(project.getEmployee());
    }

    @Test
    public void setProjectManager() {
        assertNull(project.getProjectManager());
        project.setProjectManager(projectManager);
        assertNotNull(project.getProjectManager());
    }

    @Test
    public void setProjectManagernull() {
        projectManager = null;
        assertNull(project.getProjectManager());
        project.setProjectManager(projectManager);
        assertNull(project.getProjectManager());
    }

    @Test
    public void setTeamLeader() {
        assertNull(project.getTeamLeader());
        project.setTeamLeader(teamLeader);
        assertNotNull(project.getTeamLeader());
    }

    @Test
    public void setTeamLeaderNull() {
        teamLeader = null;
        assertNull(project.getTeamLeader());
        project.setTeamLeader(teamLeader);
        assertNull(project.getTeamLeader());
    }

    @Test
    public void getEmployee() {
        assertNull(project.getEmployee());
        project.addOfficeplankton(officePlanktons);
        assertEquals(officePlanktons,project.getEmployee());
    }

    @Test
    public void getBudget() {
        Project project1 = new Project("Project", 10000);
        assertEquals(10000,project1.getBudget(),0.00000001);
    }

    @Test
    public void getName() {
        Project project1 = new Project("Project", 10000);
        assertEquals("Project",project1.getName());
    }

    @Test
    public void getTeamLeader() {
        assertNull(project.getTeamLeader());
        project.setTeamLeader(teamLeader);
        assertEquals(teamLeader, project.getTeamLeader());
    }

    @Test
    public void getProjectManager() {
        assertNull(project.getProjectManager());
        project.setProjectManager(projectManager);
        assertEquals(projectManager,project.getProjectManager());
    }
}