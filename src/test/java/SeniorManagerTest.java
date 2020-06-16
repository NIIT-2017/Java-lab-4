import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class SeniorManagerTest {

    HashMap<String, Double> mapProjectsPercent=new HashMap <String, Double>(){{
        put("Operation monitoring of a resource", 0.0075);
        put("Unmanned control", 0.012);
        put("Workshop planning", 0.011);
        put("Internet of things in production", 0.013);
        put("Online store", 0.0005);
    }};

    SeniorManager seniorManager=new SeniorManager(111, "Наумов Сергей Степанович",mapProjectsPercent,53);

    @org.junit.Test
    public void checkToString() {
        assertEquals("SeniorManager",seniorManager.toString());
    }
}