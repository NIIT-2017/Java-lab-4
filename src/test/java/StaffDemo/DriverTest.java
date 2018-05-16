package StaffDemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DriverTest {
    private ArrayList<Driver> drivers;
    private Driver driver;
    @Before
    public void setUp() throws Exception {
        drivers = new ArrayList<Driver>();
        for (int i = 0; i < 5; i++) {
            drivers.add(new Driver("Dsurname"+i,"Dname"+i,"Dsecondname"+i));
        }
        driver = drivers.get(0);
    }

    @Test
    public void setRateOverTimeHour() {
        assertEquals(0, driver.getRateOverTimeHour(), 0.00000001);
        driver.setRateOverTimeHour(600);
        assertEquals(600, driver.getRateOverTimeHour(), 0.00000001);
    }

    @Test
    public void setRateOverTimeHourNegative() {
        assertEquals(0, driver.getRateOverTimeHour(), 0.00000001);
        driver.setRateOverTimeHour(-600);
        assertEquals(0, driver.getRateOverTimeHour(), 0.00000001);
    }

    @Test
    public void setOverTimeHours() {
        assertEquals(0, driver.getOverTimeHours(), 0.00000001);
        driver.setOverTimeHours(10);
        assertEquals(10, driver.getOverTimeHours(), 0.00000001);
    }

    @Test
    public void setOverTimeHoursNegative() {
        assertEquals(0, driver.getOverTimeHours(), 0.00000001);
        driver.setOverTimeHours(-10);
        assertEquals(0, driver.getOverTimeHours(), 0.00000001);
    }

    @Test
    public void getDrivers() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Cleaner("Csurname", "Cname", "Csecondname"));
        employees.add(new Manager("Msurname", "Mname", "Msecondname"));
        employees.add(new Programmer("Psurname", "Pname", "Psecondname"));
        employees.addAll(drivers);
        assertEquals(drivers,Driver.getDrivers(employees));
    }

    @Test
    public void calcPaymentOverTIme() {
        int i=0;
        for (Driver next : drivers) {
            assertEquals(0,next.calcPaymentOverTIme(),0.000000001);
            next.setOverTimeHours(1+i%3);
            next.setRateOverTimeHour(100*i%3);
            assertEquals((1+i%3)*(100*i%3),next.calcPaymentOverTIme(),0.00000001);
            i++;
        }
    }

    @Test
    public void calcPayment() {
        int i=0;
        for (Driver next : drivers) {
            assertEquals(0,next.calcPaymentOverTIme(),0.000000001);
            next.setOverTimeHours(1+i%3);
            next.setRateOverTimeHour(100*i%3);
            next.setWorkHours(1+i%2);
            next.setRateWorkHour(100*i%2);
            next.calcPayment();
            assertEquals((1+i%3)*(100*i%3)+(1+i%2)*(100*i%2),next.getPayment(),0.00000001);
            i++;
        }
    }
}