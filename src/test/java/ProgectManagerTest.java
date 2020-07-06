import org.junit.Test;

import static org.junit.Assert.*;

public class ProgectManagerTest {

    @Test
    public void calcSalary() {
        ProgectManager test = ProgectManager.generate(100,"Test","ProgectManager",
                "Allprogect",1.0f,0);
        assertEquals(4500000,test.CalcSalary(),1.0);
    }

    @Test
    public void calcSalary1() {
        ProgectManager test = ProgectManager.generate(100,"Test","ProgectManager",
                "Allprogect",0.0f,5);
        assertEquals(250000,test.CalcSalary(),1.0);
    }

}