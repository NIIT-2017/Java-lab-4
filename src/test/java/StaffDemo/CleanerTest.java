package StaffDemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CleanerTest {
    private ArrayList<Cleaner> cleaners;
    private Cleaner cleaner;

    @Before
    public void setUp() throws Exception {
        cleaners = new ArrayList<Cleaner>();
        for (int i = 0; i < 5; i++) {
            cleaners.add(new Cleaner("Csurname" + i, "Cname" + i, "Csecondname" + i));
        }
        cleaner = cleaners.get(0);
    }

    @Test
    public void calcPayment() {
        int i = 0;
        for (Cleaner next : cleaners) {
            next.setWorkHours(8+i%3);
            next.setRateWorkHour(300*i%3);
            assertEquals((8+i%3)*(300*i%3),next.getPayment(),0.00000001);
            i++;
        }
    }

    @Test
    public void getCleaners() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Manager("Msurname", "Mname", "Msecondname"));
        employees.add(new Programmer("Psurname", "Pname", "Psecondname"));
        employees.addAll(cleaners);
        assertEquals(cleaners,Cleaner.getCleaners(employees));
    }
}