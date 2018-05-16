package StaffDemo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonalTest {
    private Personal cleaner;
    private Personal driver;
    @Before
    public void setUp() throws Exception {
        cleaner = new Cleaner("1","Csurname", "Cname", "Csecondname");
        driver = new Driver("2","Dsurname", "Dname", "Dsecondname");
    }

    @Test
    public void setWorkHours() {
        assertEquals(0,cleaner.getWorkHours(),0.00000001);
        cleaner.setWorkHours(48);
        assertEquals(48,cleaner.getWorkHours(),0.00000001);
        assertEquals(0,driver.getWorkHours(),0.00000001);
        driver.setWorkHours(50);
        assertEquals(50,driver.getWorkHours(),0.00000001);

    }

    @Test
    public void setWorkHoursNegative() {
        assertEquals(0,cleaner.getWorkHours(),0.00000001);
        cleaner.setWorkHours(-48);
        assertEquals(0,cleaner.getWorkHours(),0.00000001);
        assertEquals(0,driver.getWorkHours(),0.00000001);
        driver.setWorkHours(-50);
        assertEquals(0,driver.getWorkHours(),0.00000001);
    }

    @Test
    public void setRatePerWorkHour() {
        assertEquals(0,cleaner.getRatePerWorkHour(),0.00000001);
        cleaner.setRateWorkHour(500);
        assertEquals(500,cleaner.getRatePerWorkHour(),0.00000001);
        assertEquals(0,driver.getRatePerWorkHour(),0.00000001);
        driver.setRateWorkHour(400);
        assertEquals(400,driver.getRatePerWorkHour(),0.00000001);
    }

    @Test
    public void setRatePerWorkHourNegative() {
        assertEquals(0,cleaner.getRatePerWorkHour(),0.00000001);
        cleaner.setRateWorkHour(-500);
        assertEquals(0,cleaner.getRatePerWorkHour(),0.00000001);
        assertEquals(0,driver.getRatePerWorkHour(),0.00000001);
        driver.setRateWorkHour(-400);
        assertEquals(0,driver.getRatePerWorkHour(),0.00000001);
    }

    @Test
    public void calcPaymentWorkTime() {
        assertEquals(0,cleaner.calcPaymentWorkTime(),0.00000001);
        cleaner.setRateWorkHour(500);
        cleaner.setWorkHours(40);
        assertEquals(40*500,cleaner.calcPaymentWorkTime(),0.00000001);

        assertEquals(0,driver.calcPaymentWorkTime(),0.00000001);
        driver.setRateWorkHour(400);
        driver.setWorkHours(20);
        assertEquals(20*400,driver.calcPaymentWorkTime(),0.00000001);
    }
}