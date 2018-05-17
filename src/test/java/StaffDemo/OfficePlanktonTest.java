package StaffDemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OfficePlanktonTest {
    private ArrayList<OfficePlankton> officePlanktons;
    private ArrayList<Project> projects;
    @Before
    public void setUp() throws Exception {
        officePlanktons = new ArrayList<OfficePlankton>();
        officePlanktons.add(new Programmer("Psurname", "Pname", "Psecondname"));
        officePlanktons.add(new Tester("Tsurname", "Tname", "Tsecondname"));
        officePlanktons.add(new TeamLeader("TLsurname", "TLname", "TLsecondname"));
        officePlanktons.add(new Manager("Msurname", "Pname", "Psecondname"));
        officePlanktons.add(new ProjectManager("PMsurname", "PMname", "PMsecondname"));

        projects = new ArrayList<Project>();
        projects.add(new Project("firstProject", 10000));
        projects.add(new Project("secondProject", 10000));
        projects.add(new Project("thirdProject", 10000));
    }

    @Test
    public void setProject() {
        int i =0;
        for (OfficePlankton next : officePlanktons) {
            next.setProject(projects.get(i%3));
            assertEquals(next.getProject(),projects.get(i%3));
            i++;
        }
    }

    @Test
    public void getProject() {
        for (OfficePlankton next : officePlanktons) {
            assertNull(next.getProject());
            next.setProject(projects.get(0));
            assertEquals(next.getProject(),projects.get(0));
        }
    }

    @Test
    public void calcPaymentForPartOfProject() {
        Project project = new Project("Project", 100000);
        project.addOfficeplankton(officePlanktons);
        for (OfficePlankton next : officePlanktons) {
            next.setRatePerProject(0.01);
            assertEquals(0.01 * project.getBudget(), next.calcPaymentForPartOfProject(), 0.00000001);
        }
    }

    @Test
    public void setRatePerProject() {
        for (OfficePlankton next : officePlanktons) {
            assertEquals(0,next.getRatePerProject(),0.00000001);
            next.setRatePerProject(0.01);
            assertEquals(0.01, next.getRatePerProject(), 0.00000001);
        }
    }

    @Test
    public void setRatePerProjectNegative() {
        for (OfficePlankton next : officePlanktons) {
            assertEquals(0,next.getRatePerProject(),0.00000001);
            next.setRatePerProject(-0.01);
            assertEquals(0, next.getRatePerProject(), 0.00000001);
        }
    }

    @Test
    public void getRatePerProject() {
        int i = 0;
        for (OfficePlankton next : officePlanktons) {

            assertEquals(0, next.getRatePerProject(), 0.00000001);
            next.setRatePerProject(10 * i % 3);
            assertEquals((10 * i % 3), next.getRatePerProject(), 0.00000001);
            i++;
        }
    }
}