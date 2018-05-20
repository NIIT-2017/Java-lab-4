import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @Test
    void setCalculatedWorkTime() {
        Driver Personal=new Driver("Abram","324234",100,180);

        int expected=18000+18000*20/100;
        Assert.assertEquals(expected,Personal.getPayment());
    }
}