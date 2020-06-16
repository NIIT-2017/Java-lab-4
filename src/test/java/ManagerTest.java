import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    HashMap<String, Double> mapProjectsPercent=new HashMap <String, Double>(){{
        put("Operation monitoring of a resource", 0.005);
        put("Unmanned control", 0.007);
    }};

    Manager manager=new Manager(456,"Хомутов Степан Сергеевич",mapProjectsPercent);

    @org.junit.Test
    public void checkGetMapProjectsPercent() {
        HashMap<String, Double> expMapProjectsPercent=new HashMap <String, Double>(){{
            put("Operation monitoring of a resource", 0.005);
            put("Unmanned control", 0.007);
        }};
        assertEquals(expMapProjectsPercent,manager.getMapProjectsPercent());
    }

    @org.junit.Test
    public void checkCalcProject() {
        assertEquals(47343.95585,manager.calcProject(mapProjectsPercent));
    }

    @org.junit.Test
    public void checkCalc() {
        assertEquals(47343.95585,manager.calc());
    }

    @org.junit.Test
    public void checkToString() {
        assertEquals("Manager",manager.toString());
    }
}