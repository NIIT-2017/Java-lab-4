import org.junit.Test;

import static org.junit.Assert.*;

public class ClassesTest {

    @Test
    public void setPaymentCleaner() {
        Cleaner one = new Cleaner((byte)101,"Anna", (short)10);
        assertEquals("Cleaner", one.getPosition());
        assertEquals(101,one.getId());
        assertEquals("Anna", one.getName());
        assertEquals(1600, one.getPayment());
        one = null;
        Bookkeeping two = new Bookkeeping();
        two.setCleanerList((byte)101,"Anna", (short)10);
        assertEquals("Cleaner", two.getBook(0).getPosition());
        assertEquals(101,two.getBook(0).getId());
        assertEquals("Anna", two.getBook(0).getName());
        assertEquals(1600, two.getBook(0).getPayment());
    }

    @Test
    public void setPaymentDriver() {
        Driver one = new Driver((byte)12,"Roman", (short)10);
        assertEquals("Driver", one.getPosition());
        assertEquals(12,one.getId());
        assertEquals("Roman", one.getName());
        assertEquals(1600, one.getPayment());
        one = null;
        Bookkeeping two = new Bookkeeping();
        two.setDriverList((byte)12,"Roman", (short)10);
        assertEquals("Driver", two.getBook(0).getPosition());
        assertEquals(12,two.getBook(0).getId());
        assertEquals("Roman", two.getBook(0).getName());
        assertEquals(1600, two.getBook(0).getPayment());
    }

    @Test
    public void setPaymentProgrammer() {
        Programmer one = new Programmer((byte)18,"Nikolas", (short)10, (byte)10, "Java database");
        assertEquals("Programmer", one.getPosition());
        assertEquals(18,one.getId());
        assertEquals("Nikolas", one.getName());
        assertEquals(101600, one.getPayment());
        assertEquals("Java database", one.getProject());
        one = null;
        Bookkeeping two = new Bookkeeping();
        two.setProgrammerList((byte)18,"Nikolas", (short)10, (byte)10, "Java database");
        assertEquals("Programmer", two.getBook(0).getPosition());
        assertEquals(18,two.getBook(0).getId());
        assertEquals("Nikolas", two.getBook(0).getName());
        assertEquals(101600, two.getBook(0).getPayment());
        assertEquals("Java database", two.getBook(0).getProject());
    }

    @Test
    public void setPaymentTester() {
        Tester one = new Tester((byte)23,"Vika", (short)10, (byte)10, "Typescript");
        assertEquals("Tester", one.getPosition());
        assertEquals(23,one.getId());
        assertEquals("Vika", one.getName());
        assertEquals(51600, one.getPayment());
        assertEquals("Typescript", one.getProject());
        one = null;
        Bookkeeping two = new Bookkeeping();
        two.setTesterList((byte)23,"Vika", (short)10, (byte)10, "Typescript");
        assertEquals("Tester", two.getBook(0).getPosition());
        assertEquals(23,two.getBook(0).getId());
        assertEquals("Vika", two.getBook(0).getName());
        assertEquals(51600, two.getBook(0).getPayment());
        assertEquals("Typescript", two.getBook(0).getProject());
    }

    @Test
    public void setPaymentTeamLeader() {
        TeamLeader one = new TeamLeader((byte)9,"Oleg", (short)10, (byte)10, "C++", (byte)5);
        assertEquals("TeamLeader", one.getPosition());
        assertEquals(9,one.getId());
        assertEquals("Oleg", one.getName());
        assertEquals(201600, one.getPayment());
        assertEquals("C++", one.getProject());
        one = null;
        Bookkeeping two = new Bookkeeping();
        two.setTeamLeaderList((byte)9,"Oleg", (short)10, (byte)10, "C++", (byte)5);
        assertEquals("TeamLeader", two.getBook(0).getPosition());
        assertEquals(9,two.getBook(0).getId());
        assertEquals("Oleg", two.getBook(0).getName());
        assertEquals(201600, two.getBook(0).getPayment());
        assertEquals("C++", two.getBook(0).getProject());
    }

    @Test
    public void setPaymentManager() {
        Manager one = new Manager((byte)18,"Nikolas", (byte)10, "Java database");
        assertEquals("Manager", one.getPosition());
        assertEquals(18,one.getId());
        assertEquals("Nikolas", one.getName());
        assertEquals(100000, one.getPayment());
        assertEquals("Java database", one.getProject());
        one = null;
        Bookkeeping two = new Bookkeeping();
        two.setManagerList((byte)18,"Nikolas", (byte)10, "Java database");
        assertEquals("Manager", two.getBook(0).getPosition());
        assertEquals(18,two.getBook(0).getId());
        assertEquals("Nikolas", two.getBook(0).getName());
        assertEquals(100000, two.getBook(0).getPayment());
        assertEquals("Java database", two.getBook(0).getProject());
    }

    @Test
    public void setPaymentProjectManager() {
        ProjectManager one = new ProjectManager((byte)9,"Oleg", (byte)10, "C++", (byte)5);
        assertEquals("ProjectManager", one.getPosition());
        assertEquals(9,one.getId());
        assertEquals("Oleg", one.getName());
        assertEquals(200000, one.getPayment());
        assertEquals("C++", one.getProject());
        one = null;
        Bookkeeping two = new Bookkeeping();
        two.setProjectManagerList((byte)9,"Oleg", (byte)10, "C++", (byte)5);
        assertEquals("ProjectManager", two.getBook(0).getPosition());
        assertEquals(9,two.getBook(0).getId());
        assertEquals("Oleg", two.getBook(0).getName());
        assertEquals(200000, two.getBook(0).getPayment());
        assertEquals("C++", two.getBook(0).getProject());
    }

    @Test
    public void setPaymentSeniorManager() {
        SeniorManager one = new SeniorManager((byte)9,"Oleg", (byte)10, "Java database", (byte)10, "Typescript", (byte)10, "C++", (byte)10);
        assertEquals("SeniorManager", one.getPosition());
        assertEquals(9,one.getId());
        assertEquals("Oleg", one.getName());
        assertEquals(400000, one.getPayment());
        one = null;
        Bookkeeping two = new Bookkeeping();
        two.setSeniorManagerList((byte)9,"Oleg", (byte)10, "Java database", (byte)10, "Typescript", (byte)10, "C++", (byte)10);
        assertEquals("SeniorManager", two.getBook(0).getPosition());
        assertEquals(9,two.getBook(0).getId());
        assertEquals("Oleg", two.getBook(0).getName());
        assertEquals(400000, two.getBook(0).getPayment());
    }

    @Test
    public void createJson() {
        Bookkeeping one = new Bookkeeping();
        one.setCleanerList((byte)101,"Anna", (short)10);
        one.setDriverList((byte)12,"Roman", (short)10);
        one.setProgrammerList((byte)18,"Nikolas", (short)10, (byte)10, "Java database");
        one.setTesterList((byte)23,"Vika", (short)10, (byte)10, "Typescript");
        one.setTeamLeaderList((byte)9,"Oleg", (short)10, (byte)10, "C++", (byte)5);
        one.setManagerList((byte)18,"Nikolas", (byte)10, "Java database");
        one.setProjectManagerList((byte)9,"Oleg", (byte)10, "C++", (byte)5);
        one.setSeniorManagerList((byte)9,"Oleg", (byte)10, "Java database", (byte)10, "Typescript", (byte)10, "C++", (byte)10);
        one.createJson("test.json");
        one = null;
        Bookkeeping two = new Bookkeeping();
        two.readJson("test.json");
        assertEquals("Cleaner", two.getBook(0).getPosition());
        assertEquals(101,two.getBook(0).getId());
        assertEquals("Anna", two.getBook(0).getName());
        assertEquals(1600, two.getBook(0).getPayment());
        assertEquals("Driver", two.getBook(1).getPosition());
        assertEquals(12,two.getBook(1).getId());
        assertEquals("Roman", two.getBook(1).getName());
        assertEquals(1600, two.getBook(1).getPayment());
        assertEquals("Programmer", two.getBook(2).getPosition());
        assertEquals(18,two.getBook(2).getId());
        assertEquals("Nikolas", two.getBook(2).getName());
        assertEquals(101600, two.getBook(2).getPayment());
        assertEquals("Java database", two.getBook(2).getProject());
        assertEquals("Tester", two.getBook(3).getPosition());
        assertEquals(23,two.getBook(3).getId());
        assertEquals("Vika", two.getBook(3).getName());
        assertEquals(51600, two.getBook(3).getPayment());
        assertEquals("Typescript", two.getBook(3).getProject());
        assertEquals("TeamLeader", two.getBook(4).getPosition());
        assertEquals(9,two.getBook(4).getId());
        assertEquals("Oleg", two.getBook(4).getName());
        assertEquals(201600, two.getBook(4).getPayment());
        assertEquals("C++", two.getBook(4).getProject());
        assertEquals("Manager", two.getBook(5).getPosition());
        assertEquals(18,two.getBook(5).getId());
        assertEquals("Nikolas", two.getBook(5).getName());
        assertEquals(100000, two.getBook(5).getPayment());
        assertEquals("Java database", two.getBook(5).getProject());
        assertEquals("ProjectManager", two.getBook(6).getPosition());
        assertEquals(9,two.getBook(6).getId());
        assertEquals("Oleg", two.getBook(6).getName());
        assertEquals(200000, two.getBook(6).getPayment());
        assertEquals("C++", two.getBook(6).getProject());
        assertEquals("SeniorManager", two.getBook(7).getPosition());
        assertEquals(9,two.getBook(7).getId());
        assertEquals("Oleg", two.getBook(7).getName());
        assertEquals(400000, two.getBook(7).getPayment());
    }
}


