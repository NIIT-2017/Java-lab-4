package StaffDemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProjectManagerTest {
    private ArrayList<ProjectManager> projectManagers;
    private ArrayList<Project> projects;
    private ArrayList<OfficePlankton> officePlanktons;

    @Before
    public void setUp() throws Exception {
        projectManagers = new ArrayList<ProjectManager>();
        projects = new ArrayList<Project>();
        officePlanktons = new ArrayList<OfficePlankton>();
        for (int i = 0; i < 5; i++) {
            projectManagers.add(new ProjectManager("PMsurname" + i, "PMname" + i, "PMsecondname" + i));
            projects.add(new Project("Project" + i, 100000));
            projects.get(i).setProjectManager(projectManagers.get(i));
            projects.get(i).setTeamLeader(new TeamLeader("TMsurname", "TMname", "TMsecondname"));
        }
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
    public void setRatePerEmployees() {
        int i = 0;
        for (ProjectManager next : projectManagers) {
            assertEquals(0,next.getRatePerEmployees(),0.00000001);
            next.setRatePerEmployees(1000*i%3);
            assertEquals(1000*i%3,next.getRatePerEmployees(),0.00000001);
            i++;
        }
    }

    @Test
    public void setRatePerEmployeesNegative() {
        ProjectManager projectManager = projectManagers.get(0);
        assertEquals(0,projectManager.getRatePerEmployees(),0.00000001);
        projectManager.setRatePerEmployees(-1000);
        assertEquals(0,projectManager.getRatePerEmployees(),0.00000001);
    }

    @Test
    public void getProjectManagers() {
        ArrayList<Employee> employees = new ArrayList<Employee>(projectManagers);
        employees.addAll(officePlanktons);
        assertEquals(projectManagers,ProjectManager.getProjectManagers(employees));
    }

    @Test
    public void calcPaymentForHeading() {
        ProjectManager projectManager = projectManagers.get(0);
        projectManager.getProject().addOfficeplankton(officePlanktons);
        projectManager.setRatePerEmployees(1000);
        //+1 это  Teamleader
        assertEquals(1000 * (1+projectManager.getProject().getEmployee().size()), projectManager.calcPaymentForHeading(), 0.00000001);
    }

    @Test
    public void calcPayment() {
        int i = 0;
        for (ProjectManager next : projectManagers) {
            next.setRatePerEmployees(1000*i%3);
            next.setRatePerProject(0.01*i%3);
            next.getProject().addOfficeplankton(officePlanktons);
            double payment = (1000 * i % 3) * next.getProject().getEmployee().size() +
                    (0.01*i%3)*next.getProject().getBudget();
            next.calcPayment();
            assertEquals(payment, next.getPayment(),0.00000001);
        }
    }

    @Test
    public void getRatePerEmployees() {
        ProjectManager projectManager = projectManagers.get(0);
        assertEquals(0,projectManager.getRatePerEmployees(),0.00000001);
        projectManager.setRatePerEmployees(1000);
        assertEquals(1000,projectManager.getRatePerEmployees(),0.00000001);

    }
}