import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkersTest {

    public static Driver testDriver = new Driver(101, "testDriver", 10);
    public static Cleaner testCleaner = new Cleaner(102, "testCleaner", 10);

    @BeforeClass
    public static void start(){
        HR.delStaff();
        Accounting.delProject();
        HR.addStaff(testDriver);
        HR.addStaff(testCleaner);
        testCleaner.setWorktime(100);
        testDriver.setWorktime(100);
    }

    @Test
    public void moneyForWorktime() {
        assertEquals(1125, testDriver.moneyForWorktime(), 0.1f);
        assertEquals(600, testCleaner.moneyForWorktime(), 0.1f);
    }
}