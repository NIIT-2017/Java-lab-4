package StaffDemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ManagerTest {
    private ArrayList<Manager> managers;
    private Project project;
    @Before
    public void setUp() throws Exception {
        managers = new ArrayList<Manager>();
        for (int i = 0; i < 3; i++) {
            managers.add(new Manager("Msurname"+i, "Mname"+i, "Msecondname"+i));
        }
        project = new Project("Project",100000);
    }

    @Test
    public void calcPayment() {
        int i=0;
        project.addOfficeplankton(managers);
        for (Manager next : managers) {
            assertEquals(0, next.getPayment(), 0.00000001);
            next.setRatePerProject(0.01*i%3);
            next.calcPayment();
            assertEquals(0.01*i%3*project.getBudget(),next.getPayment(),0.00000001);
            i++;
        }
    }

    @Test
    public void getManagers() {
        ArrayList<Employee> employees = new ArrayList<Employee>(managers);
        employees.add(new Cleaner("Csurname", "Cname", "Csecondname"));
        employees.add(new Driver("Dsurname", "Dname", "Dsecondname"));
        assertEquals(managers,Manager.getManagers(employees));
    }
}