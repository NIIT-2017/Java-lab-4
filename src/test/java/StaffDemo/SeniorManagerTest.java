package StaffDemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SeniorManagerTest {
    private ArrayList<Project> projects;
    private SeniorManager seniorManager;
    @Before
    public void setUp() throws Exception {
        projects = new ArrayList<Project>();
        for (int i = 0; i < 5; i++) {
            projects.add(new Project("Project" + i, 100000));
        }
        seniorManager = new SeniorManager("SMsurname", "SMname", "SMsecondname");
    }

    @Test
    public void setProjects() {
        assertNull(seniorManager.getProjects());
        seniorManager.setProjects(projects);
        assertEquals(projects,seniorManager.getProjects());
    }

    @Test
    public void setRatePerProject() {
        assertEquals(0, seniorManager.getRatePerProject(), 0.00000001);
        seniorManager.setRatePerProject(1000);
        assertEquals(1000, seniorManager.getRatePerProject(), 0.00000001);
    }

    @Test
    public void setRatePerProjectNegative() {
        assertEquals(0, seniorManager.getRatePerProject(), 0.00000001);
        seniorManager.setRatePerProject(-1000);
        assertEquals(0, seniorManager.getRatePerProject(), 0.00000001);
    }

    @Test
    public void getRatePerProject() {
        seniorManager.setRatePerProject(1000);
        assertEquals(1000, seniorManager.getRatePerProject(), 0.00000001);
    }

    @Test
    public void getProjects() {
        assertNull(seniorManager.getProjects());
        seniorManager.setProjects(projects);
        assertNotNull(seniorManager.getProjects());
    }

    @Test
    public void getSeniorManager() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(seniorManager);
        employees.add(new Cleaner("Csurname", "Cname", "Csecondname"));
        employees.add(new Driver("Dsurname", "Dname", "Dsecondname"));
        employees.add(new Manager("Msurname", "Mname", "Msecondname"));
        assertEquals(seniorManager, SeniorManager.getSeniorManager(employees));

    }

    @Test
    public void calcPayment() {
        seniorManager.setProjects(projects);
        seniorManager.setRatePerProject(10000);
        seniorManager.calcPayment();
        assertEquals(10000 * projects.size(), seniorManager.getPayment(), 0.00000001);
    }
}