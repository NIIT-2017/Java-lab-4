import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {

    Company companyTest = new Company();

    @org.junit.Test
    public void checkCompanyMade() {

        assertEquals(8,companyTest.companyMade("/test.json"));
    }

    @org.junit.Test
    public void checkGiveWorkTime() {
        companyTest.companyMade("/test.json");

        companyTest.giveWorkTime(25);
        assertNotEquals(0,companyTest.company.get(0).getWorkTime());
        assertNotEquals(0,companyTest.company.get(1).getWorkTime());
        assertNotEquals(0,companyTest.company.get(2).getWorkTime());
        assertNotEquals(0,companyTest.company.get(3).getWorkTime());
        assertNotEquals(0,companyTest.company.get(4).getWorkTime());
        assertNotEquals(0,companyTest.company.get(5).getWorkTime());
        assertNotEquals(0,companyTest.company.get(6).getWorkTime());
        assertNotEquals(0,companyTest.company.get(7).getWorkTime());

    }

    @org.junit.Test
    public void checkCalcPaymentForCompany() {
        companyTest.companyMade("/test.json");

        companyTest.company.get(0).setWorkTime(23);
        companyTest.company.get(1).setWorkTime(20);
        companyTest.company.get(2).setWorkTime(58);
        companyTest.company.get(3).setWorkTime(26);
        companyTest.company.get(4).setWorkTime(26);
        companyTest.company.get(5).setWorkTime(44);
        companyTest.company.get(6).setWorkTime(33);
        companyTest.company.get(7).setWorkTime(15);

        companyTest.calcPaymentForCompany();
        assertEquals(3614.0452,companyTest.company.get(0).getPayment());
        assertEquals(5314.104,companyTest.company.get(1).getPayment());
        assertEquals(24602.608265000003,companyTest.company.get(2).getPayment());
        assertEquals(9895.7896462,companyTest.company.get(3).getPayment());
        assertEquals(27572.090287,companyTest.company.get(4).getPayment());
        assertEquals(19310.35543,companyTest.company.get(5).getPayment());
        assertEquals(201687.730165,companyTest.company.get(6).getPayment());
        assertEquals(339376.399225,companyTest.company.get(7).getPayment());
    }

    @org.junit.Test
    public void checkGetAllPaymentToFile() {
        String timeStamp = new SimpleDateFormat("dd_MM_yyyy").format(Calendar.getInstance().getTime()); //for nameFile

        companyTest.companyMade("/test.json");
        companyTest.giveWorkTime(15);
        companyTest.calcPaymentForCompany();

        companyTest.getAllPaymentToFile();
        File file=new File("AllPayment_" + timeStamp + ".json");

        assertEquals(true, file.isFile());
    }
}