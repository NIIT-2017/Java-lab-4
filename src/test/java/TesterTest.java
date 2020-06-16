import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TesterTest {

    HashMap<String, Double> mapProjectsPercent=new HashMap<String, Double>(){{
        put("Operation monitoring of a resource",0.0003);
        put("Workshop planning",0.0005);
    }};

    Tester tester=new Tester(567,"Смирнов Евгений Александрович", 32189.2, mapProjectsPercent,0.007);

    @org.junit.Test
    public void checkGetPercentCode() {
        assertEquals(0.007,tester.getPercentCode());
    }

    @org.junit.Test
    public void checkSetPercentCode() {
        tester.setPercentCode(0.0011);
        assertEquals(0.0011,tester.getPercentCode());
    }

    @org.junit.Test
    public void checkQualityCode() {
        assertEquals(230.15278,tester.qualityCode(0.0055));
    }

    @org.junit.Test
    public void checkCalc() {
        tester.setWorkTime(42);
        assertEquals(16586.740775,tester.calc());
    }

    @org.junit.Test
    public void checkToString() {
        assertEquals("Tester",tester.toString());
    }
}