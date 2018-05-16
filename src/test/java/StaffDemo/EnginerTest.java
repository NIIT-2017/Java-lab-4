package StaffDemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EnginerTest {

    private ArrayList<Enginer> enginers;
    private Enginer enginer;
    @Before
    public void setUp() throws Exception {
        enginers = new ArrayList<Enginer>();
        enginers.add(new Programmer("Psurname", "Pname", "Psecondname"));
        enginers.add(new Tester("Tsurname", "Tname", "Tsecondname"));
        enginers.add(new TeamLeader("TLsurname", "TLname", "TLsecondname"));
        enginer = enginers.get(0);
    }

    @Test
    public void setRatePerProject() {
        for (Enginer next : enginers) {
            assertEquals(0,next.getPartOfProject(),0.00000001);
            next.setRatePerProject(0.01);
            assertEquals(0.01, next.getPartOfProject(), 0.00000001);
        }
    }

    @Test
    public void setRateWorkHour() {
        for (Enginer next : enginers) {
            assertEquals(0, next.getRateWorkHour(), 0.00000001);
            next.setRateWorkHour(400);
            assertEquals(400, next.getRateWorkHour(), 0.00000001);
        }
    }

    @Test
    public void setWorkHours() {
        for (Enginer next : enginers) {
            assertEquals(0, next.getWorkHours(), 0.00000001);
            next.setWorkHours(40);
            assertEquals(40, next.getWorkHours(), 0.00000001);
        }
    }

    @Test
    public void setRatePerProjectNegative() {
        for (Enginer next : enginers) {
            assertEquals(0,next.getPartOfProject(),0.00000001);
            next.setRatePerProject(-0.01);
            assertEquals(0, next.getPartOfProject(), 0.00000001);
        }
    }

    @Test
    public void setRateWorkHourNegative() {
        for (Enginer next : enginers) {
            assertEquals(0, next.getRateWorkHour(), 0.00000001);
            next.setRateWorkHour(-400);
            assertEquals(0, next.getRateWorkHour(), 0.00000001);
        }
    }

    @Test
    public void setWorkHoursNegative() {
        for (Enginer next : enginers) {
            assertEquals(0, next.getWorkHours(), 0.00000001);
            next.setWorkHours(-40);
            assertEquals(0, next.getWorkHours(), 0.00000001);
        }
    }

    @Test
    public void calcPaymentForPartOfProject() {
        Project project = new Project("Project", 100000);
        project.addOfficeplankton(enginers);
        for (Enginer next : enginers) {
            next.setRatePerProject(0.01);
            assertEquals(0.01 * project.getBudget(), next.calcPaymentForPartOfProject(), 0.00000001);
        }
    }

    @Test
    public void calcPaymentWorkTime() {
        int i=0;
        for (Enginer next : enginers) {
            next.setWorkHours(8+i%3);
            next.setRateWorkHour(200*i%3);
            assertEquals((8 + i % 3) * (200 * i % 3), next.calcPaymentWorkTime(), 0.00000001);
            i++;
        }
    }

    @Test
    public void getPartOfProject() {
        int i = 0;
        for (Enginer next : enginers) {
            assertEquals(0, next.getPartOfProject(), 0.00000001);
            next.setRatePerProject(10*i%3);
            assertEquals((10 * i % 3), next.getPartOfProject(), 0.00000001);
            i++;
        }
    }
}