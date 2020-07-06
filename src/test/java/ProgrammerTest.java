import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class ProgrammerTest {

    HashMap<String, Double> mapProjectsPercent=new HashMap<String, Double>(){{
        put("Operation monitoring of a resource",0.0003);
        put("Unmanned control",0.0007);
        put("Workshop planning",0.0005);
    }};

    Programmer programmer=new Programmer(111,"Зыков Вадим Валерьевич",33126.26,mapProjectsPercent);


    @org.junit.Test
    public void checkCalc() {
        programmer.setWorkTime(33);
        assertEquals(16321.043265,programmer.calc());
    }

    @org.junit.Test
    public void checkToString() {
        assertEquals("Programmer",programmer.toString());
    }
}