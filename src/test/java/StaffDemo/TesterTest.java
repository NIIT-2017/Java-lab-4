package StaffDemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TesterTest {
    ArrayList<Tester> testers;
    Project project;
    @Before
    public void setUp() throws Exception {
        testers = new ArrayList<Tester>();
        project = new Project("Project",10000);
        for (int i = 0; i < 5; i++) {
            testers.add(new Tester("Tsurname" + i, "Tname" + i, "Tsecondname" + i));

        }
        project.addOfficeplankton(testers);
    }

    @Test
    public void calcPayment() {
        int i =1;
        for (Tester next : testers) {
            next.setRatePerProject(0.01*i%3);
            next.setWorkHours(40+i%3);
            next.setRateWorkHour(400*i%3);
            next.calcPayment();
            double payment = (0.01 * i % 3)*project.getBudget() + (40 + i % 3) * (400 * i % 3);
            assertEquals(payment,next.getPayment(),0.00000001);
            i++;

        }
    }

    @Test
    public void getTesters() {
        ArrayList<Employee> employees = new ArrayList<Employee>(testers);
        employees.add(new Programmer("Psurname", "Pname", "Psecondname"));
        employees.add(new TeamLeader("TLsurname", "TLname", "TLsecondname"));
        employees.add(new Driver("Dsurname", "Dname", "Dsecondname"));
        assertEquals(testers, Tester.getTesters(employees));
    }
}