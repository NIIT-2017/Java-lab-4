import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClearTest {

    Clear clear = new Clear(17,"Потапова Мария Сергеевна", 17324.51);

    @org.junit.Test
    public void checkCalc() {
        clear.setWorkTime(45);
        assertEquals(7796.0295,clear.calc());
    }

    @org.junit.Test
    public void checkToString() {
        assertEquals("Clear",clear.toString());
    }
}