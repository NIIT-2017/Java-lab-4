package StaffDemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EnumMap;

import static org.junit.Assert.*;

public class EmployeeTest {

    private ArrayList<Employee> employees;

    @Before
    public void setUp() throws Exception {
        employees = new ArrayList<Employee>();
        employees.add(new Cleaner("1","Csurname","Cname","Csecondname"));
        employees.add(new Driver("2","Dsurname","Dname","Dsecondname"));
        employees.add(new Tester("3","Tsurname","Tname","Tsecondname"));
        employees.add(new Programmer("4","Psurname","Pname","Psecondname"));
        employees.add(new TeamLeader("5","TLsurname","TLname","TLsecondname"));
        employees.add(new Manager("6","Msurname","Mname","Msecondname"));
        employees.add(new ProjectManager("7","PMsurname","PMname","PMsecondname"));
        employees.add(new SeniorManager("8","SMsurname","SMname","SMsecondname"));
    }

    @Test
    public void setID() {
        int i = 10;
        for (Employee next : employees) {
            i++;
            next.setID(i);
            assertEquals(i,next.getID());
        }
    }

    @Test
    public void getFIO() {
        assertArrayEquals(new String[]{"Csurname", "Cname", "Csecondname"},employees.get(0).getFIO());
        assertArrayEquals(new String[]{"Dsurname", "Dname", "Dsecondname"},employees.get(1).getFIO());
        assertArrayEquals(new String[]{"Tsurname", "Tname", "Tsecondname"},employees.get(2).getFIO());
        assertArrayEquals(new String[]{"Psurname", "Pname", "Psecondname"},employees.get(3).getFIO());
        assertArrayEquals(new String[]{"TLsurname", "TLname", "TLsecondname"},employees.get(4).getFIO());
        assertArrayEquals(new String[]{"Msurname", "Mname", "Msecondname"},employees.get(5).getFIO());
        assertArrayEquals(new String[]{"PMsurname", "PMname", "PMsecondname"},employees.get(6).getFIO());
        assertArrayEquals(new String[]{"SMsurname", "SMname", "SMsecondname"},employees.get(7).getFIO());
    }

    @Test
    public void getID() {
        int i=0;
        for (Employee next : employees) {
            i++;
            assertEquals(i,next.getID());
        }
    }
}