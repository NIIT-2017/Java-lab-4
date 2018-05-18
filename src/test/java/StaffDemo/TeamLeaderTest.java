package StaffDemo;

import org.junit.Before;
import org.junit.Test;
import sun.security.krb5.internal.crypto.Aes128;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeamLeaderTest {
    private ArrayList<TeamLeader> teamLeaders;
    private TeamLeader teamLeader;
    private ArrayList<OfficePlankton> officePlanktons;

    @Before
    public void setUp() throws Exception {
        teamLeaders = new ArrayList<TeamLeader>();
        for (int i = 0; i < 5; i++) {
            teamLeaders.add(new TeamLeader("TLsurname" + i, "TLname" + i, "TLsecondname" + i));
        }
        teamLeader = teamLeaders.get(0);
        officePlanktons = new ArrayList<OfficePlankton>();
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
    public void getRatePer1Employees() {
        assertEquals(0, teamLeader.getRatePerEmployees(), 0.00000001);
        teamLeader.setRatePerEmployees(1000);
        assertEquals(1000, teamLeader.getRatePerEmployees(), 0.00000001);
    }

    @Test
    public void setRatePerEmployees() {
        int i = 0;
        for (TeamLeader next : teamLeaders) {
            assertEquals(0, next.getRatePerEmployees(), 0.00000001);
            next.setRatePerEmployees(1000 * i % 3);
            assertEquals(1000 * i % 3, next.getRatePerEmployees(),0.00000001);
        }
    }

    @Test
    public void setRatePerEmployeesNegative() {
            assertEquals(0, teamLeader.getRatePerEmployees(), 0.00000001);
            teamLeader.setRatePerEmployees(-1000);
            assertEquals(0, teamLeader.getRatePerEmployees(),0.00000001);
    }

    @Test
    public void getTeamLeaders() {
        ArrayList<Employee> employees = new ArrayList<Employee>(teamLeaders);
        employees.add(new Cleaner("Csurname", "Cname", "Csecondname"));
        employees.add(new Driver("Dsurname", "Dname", "Dsecondname"));
        employees.add(new Manager("Msurname", "Mname", "Msecondname"));
        assertEquals(teamLeaders,TeamLeader.getTeamLeaders(employees));
    }

    @Test
    public void calcPaymentForHeading() {
        Project project = new Project("project", 100000);
        project.setTeamLeader(teamLeader);
        ArrayList<Programmer> programmers = new ArrayList<Programmer>();
        for (int i = 0; i < 5; i++) {
            programmers.add(new Programmer("Psurname"+i, "Pname"+i, "Psecondname"+i));
        }
        teamLeader.getProject().addOfficeplankton(programmers);
        teamLeader.setRatePerEmployees(1000);
        assertEquals(1000*project.getEmployee().size(),teamLeader.calcPaymentForHeading(),0.00000001);
    }

    @Test
    public void calcPayment() {
        int i = 0;
        for (TeamLeader next : teamLeaders) {
            new Project("Project" + i, 100000).setTeamLeader(next);
            next.setRatePerEmployees(1000 * i % 3);
            next.getProject().addOfficeplankton(officePlanktons);
            next.setWorkHours(40 + i % 3);
            next.setRateWorkHour(300 * i % 3);
            next.setOvertimeHours(10 * i % 3);
            next.setRateOvertimeHour(500 * i % 3);
            next.setRatePerProject(0.01 * i % 3);
            double payment = (1000 * i % 3) * next.getProject().getEmployee().size() +
                    (40 + i % 3) * (300 * i % 3) +
                    (10 + i % 3) * (500 * i % 3) +
                    (0.01 * i % 3) * next.getProject().getBudget();
            assertEquals(payment, next.getPayment(), 0.00000001);
        }
    }
}