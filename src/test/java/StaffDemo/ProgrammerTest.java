package StaffDemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProgrammerTest {
    private ArrayList<Programmer> programmers;
    private Programmer programmer;
    private TeamLeader teamLeader;

    @Before
    public void setUp() throws Exception {
        programmers = new ArrayList<Programmer>();
        for (int i = 0; i < 5; i++) {
            programmers.add(new Programmer("Psurname"+i, "Pname"+i, "Psecondname"+i));
        }
        teamLeader = new TeamLeader("TLsurname", "TLname", "TLsecondname");
        programmers.add(teamLeader);
        programmer = programmers.get(0);
    }

    @Test
    public void getOvertimeHours() {
        assertEquals(0, programmer.getOvertimeHours(), 0.00000001);
        programmer.setOvertimeHours(40);
        assertEquals(40, programmer.getOvertimeHours(), 0.00000001);

    }

    @Test
    public void setRateOvertimeHour() {
        int i=0;
        for (Programmer next : programmers) {
            assertEquals(0,next.getRateOvertimeHour(),0.00000001);
            next.setRateOvertimeHour(400*i%3);
            assertEquals(400*i%3,next.getRateOvertimeHour(),0.00000001);
        }
    }

    @Test
    public void setRateOvertimeHourNegative() {
        assertEquals(0, programmer.getOvertimeHours(), 0.00000001);
        programmer.setOvertimeHours(-40);
        assertEquals(0, programmer.getOvertimeHours(), 0.00000001);
    }

    @Test
    public void setOvertimeHours() {
        int i=0;
        for (Programmer next : programmers) {
            assertEquals(0,next.getOvertimeHours(),0.00000001);
            next.setOvertimeHours(40+i%3);
            assertEquals(40+i%3,next.getOvertimeHours(),0.00000001);
        }
    }

    @Test
    public void getProgrammers() {
        ArrayList<Employee> employees = new ArrayList<Employee>(programmers);
        employees.add(new Cleaner("Csurname", "Cname", "Csecondname"));
        employees.add(new Driver("Dsurname", "Dname", "Dsecondname"));
        employees.add(new Manager("Msurname", "Mname", "Msecondname"));
        assertNotEquals(programmers,Programmer.getProgrammers(employees));
        programmers.remove(teamLeader);
        assertEquals(programmers,Programmer.getProgrammers(employees));
    }

    @Test
    public void calcPaymentOvertime() {
        int i=0;
        for (Programmer next : programmers) {
            next.setRateOvertimeHour(400 * i % 3);
            next.setOvertimeHours(40 + i % 3);
            assertEquals((400 * i % 3) * (40 + i % 3), next.calcPaymentOvertime(),0.00000001);
        }
    }

    @Test
    public void calcPayment() {
        int i = 0;
        Project project = new Project("Project", 100000);
        project.addOfficeplankton(programmers);
        for (Programmer next : programmers) {
            next.setOvertimeHours(10 + i % 3);
            next.setRateOvertimeHour(400 * i % 3);
            next.setWorkHours(40 * i % 3);
            next.setRateWorkHour(300 * i % 3);
            next.setRatePerProject(0.01 * i % 3);
            double payment = (10 + i % 3) * (400 * i % 3) + (40 * i % 3) * (300 * i % 3) + (0.01 * i % 3) * project.getBudget();
            next.calcPayment();
            assertEquals(payment, next.getPayment(), 0.00000001);
        }
    }
}