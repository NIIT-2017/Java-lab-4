package StaffDemo;

import static org.junit.Assert.*;

public class CleanerTest {
    Cleaner cleaner;

    @org.junit.Test
    public void createNormal() {
        cleaner = new Cleaner("surname","name","secondname");
        assertNotNull(cleaner);
    }

    @org.junit.Test (expected = NumberFormatException.class)
    public void createNotNumberID() {
        cleaner = new Cleaner("ID","surname", "name", "secondname");
        assertNull(cleaner);
    }

//тесты на вычисление ЗП
    @org.junit.Test
    public void calcPaymentNormal() {
        cleaner = new Cleaner("surname","name","secondname");
        cleaner.setRatePerWorkHour(400);
        cleaner.setWorkHours(8);
        cleaner.calcPayment();
        assertEquals(8*400,cleaner.getPayment(),0.0000001);
    }

    @org.junit.Test
    public void calcPaymentNotData() {
        cleaner = new Cleaner("surname","name","secondname");
        cleaner.calcPayment();
        assertEquals(0.0,cleaner.getPayment(),0.0000001);
    }
}