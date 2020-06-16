import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class EngineerTest {

    HashMap<String, Double> mapProjectsPercent=new HashMap <String, Double>(){{
        put("Operation monitoring of a resource", 0.00025);
        put("Unmanned control", 0.0003);
    }};

    Engineer engineer=new Engineer(1234, "Лаук Денис Андреевич", 34567.3,mapProjectsPercent) {
        @Override
        double calc() {
            return 0;
        }

        @Override
        public String toString() {
            return "Engineer";
        }
    };

    @org.junit.Test
    public void checkGetBase() {
        assertEquals(34567.3,engineer.getBase());
    }

    @org.junit.Test
    public void checkSetBase() {
        engineer.setBase(44345.87);
        assertEquals(44345.87,engineer.getBase());
    }

    @org.junit.Test
    public void checkGetMapProjectsPercent() {
        HashMap<String, Double> expMapProjectsPercent=new HashMap <String, Double>(){{
            put("Operation monitoring of a resource", 0.00025);
            put("Unmanned control", 0.0003);
        }};
        assertEquals(expMapProjectsPercent,engineer.getMapProjectsPercent());
    }

    @org.junit.Test
    public void checkCalcWork() {
        assertEquals(11752.882000000001,engineer.calcWork(34));
    }

    @org.junit.Test
    public void checkCalcProject() {
        assertEquals(2180.4104774999996,engineer.calcProject(mapProjectsPercent));
    }
}