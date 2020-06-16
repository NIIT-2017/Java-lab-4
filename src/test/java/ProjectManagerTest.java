import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectManagerTest {

    HashMap<String, Double> mapProjectsPercent=new HashMap <String, Double>(){{
        put("Operation monitoring of a resource", 0.005);
        put("Unmanned control", 0.007);
        put("Workshop planning", 0.015);
        put("Internet of things in production", 0.027);
        put("Online store", 0.005);
    }};

    ProjectManager projectManager=new ProjectManager(457,"Сергеев Олег Михайлович",mapProjectsPercent,7);

    @org.junit.Test
    public void checkGetPersonal() {
        assertEquals(7, projectManager.getPersonal());
    }

    @org.junit.Test
    public void checkSetPersonal() {
        projectManager.setPersonal(8);
        assertEquals(8, projectManager.getPersonal());
    }

    @org.junit.Test
    public void checkCalcHeading() {
        projectManager.setWorkTime(67);
        assertEquals(3854.3006250000008, projectManager.calcHeading(7));
    }

    @org.junit.Test
    public void checkCalc() {
        projectManager.setWorkTime(57);
        assertEquals(124216.104285, projectManager.calc());
    }

    @org.junit.Test
    public void checkToString() {
        assertEquals("ProjectManager",projectManager.toString());
    }
}