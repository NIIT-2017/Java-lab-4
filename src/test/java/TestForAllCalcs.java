import org.junit.Test;

import static org.junit.Assert.*;

public class TestForAllCalcs {

    @Test
    public void CleanerCalc(){
        Cleaner cleaner = new Cleaner(1, "Alex", "Cleaner", 150);
        cleaner.setWorktime(168);
        cleaner.calcSalary();
        assertEquals(25200, cleaner.getPayment());
    }

    @Test
    public void DriverCalc(){
        Driver driver = new Driver(1, "Alex", "Driver", 200);
        driver.setWorktime(160);
        driver.calcSalary();
        assertEquals(32000, driver.getPayment());
    }

    @Test
    public void ProgrammerCalc() {
        Programmer programmer = new Programmer(1, "Alex", "Programmer",
                500, 9000000, 0.005);
        programmer.setWorktime(168);
        programmer.calcSalary();
        assertEquals(129000, programmer.getPayment());
    }

    @Test
    public void TesterCalc() {
        Tester tester = new Tester(1, "Alex", "Tester",
                400, 9000000, 0.003);
        tester.setWorktime(168);
        tester.calcSalary();
        assertEquals(94200, tester.getPayment());
    }

    @Test
    public void TeamLeaderCalc() {
        TeamLeader tl = new TeamLeader(1, "Alex", "Team Leader",
                600, 9000000, 0.008, 3, 0.07);
        tl.setWorktime(168);
        tl.calcSalary();
        assertEquals(209088, tl.getPayment());
    }

    @Test
    public void ProjectManagerCalc() {
        ProjectManager pm = new ProjectManager(1, "Alex", "Project Manager",
                9000000, 0.02, 10, 0.05);
        pm.calcSalary();
        assertEquals(270000, pm.getPayment());
    }

    @Test
    public void SeniorManager(){
        SeniorManager sm = new SeniorManager(1, "Alex", "Senior Manager",
                18000000, 0.03, 22, 0.03);
        sm.calcSalary();
        assertEquals(896400, sm.getPayment());
    }

}
