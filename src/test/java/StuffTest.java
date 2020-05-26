import static org.junit.Assert.*;
import org.junit.Test;

public class StuffTest {

    @org.junit.Test
    public void getStuffFromJson() {
        Stuff stuff = new Stuff();
        stuff.getStuffFromJson("./src/main/resources/stuff.json");

        assertEquals(stuff.getAllProjects().size(),3);
        assertEquals(stuff.getAllProjects().get(0).getProjectName(),"blueProject");
        assertEquals(stuff.getAllProjects().get(0).getProjectCost(),100000, 0);

        assertEquals(stuff.getAllEmployees().size(),16);
        assertEquals(stuff.getAllEmployees().get(0).getID(),111);
        assertEquals(stuff.getAllEmployees().get(0).getName(),"Arnold Bolshoi");
        assertEquals(stuff.getAllEmployees().get(0).getPosition(), POSITIONS.SeniorManager);

        assertEquals(stuff.getAllEmployees().get(10).getID(),321);
        assertEquals(stuff.getAllEmployees().get(10).getName(),"Pavel Smirnov");
        assertEquals(stuff.getAllEmployees().get(10).getPosition(), POSITIONS.Programmer);
        assertEquals(stuff.getAllEmployees().get(10).getWorktime(), 320);
        assertEquals(((Programmer) stuff.getAllEmployees().get(10)).getBase(), 200, 0);
        assertEquals(((Programmer) stuff.getAllEmployees().get(10)).getProject().getProjectName(), "blueProject");
        assertEquals(((Programmer) stuff.getAllEmployees().get(10)).getTeamLeaderName(), "Artur Panaryan");
    }

    @org.junit.Test
    public void createHeading() {
        Stuff stuff = new Stuff();
        stuff.getStuffFromJson("./src/main/resources/stuff.json");
        stuff.createHeading();

        assertEquals(((SeniorManager) stuff.getAllEmployees().get(0)).getSubordinates().size(),15);
        for (int i = 1; i < 16; i++) {
            assertTrue(((SeniorManager) stuff.getAllEmployees().get(0)).getSubordinates().contains(
                        stuff.getAllEmployees().get(i)));
        }

        assertEquals(((ProjectManager) stuff.getAllEmployees().get(3)).getSubordinates().size(),4);
        assertTrue(((ProjectManager) stuff.getAllEmployees().get(3)).getSubordinates().contains(
                stuff.getAllEmployees().get(6)));
        assertTrue(((ProjectManager) stuff.getAllEmployees().get(3)).getSubordinates().contains(
                stuff.getAllEmployees().get(9)));
        assertTrue(((ProjectManager) stuff.getAllEmployees().get(3)).getSubordinates().contains(
                stuff.getAllEmployees().get(12)));
        assertTrue(((ProjectManager) stuff.getAllEmployees().get(3)).getSubordinates().contains(
                stuff.getAllEmployees().get(13)));

        assertEquals(((TeamLeader) stuff.getAllEmployees().get(9)).getTeammates().size(),2);
        assertTrue(((TeamLeader) stuff.getAllEmployees().get(9)).getTeammates().contains(
                stuff.getAllEmployees().get(12)));
        assertTrue(((TeamLeader) stuff.getAllEmployees().get(9)).getTeammates().contains(
                stuff.getAllEmployees().get(13)));
    }

    @org.junit.Test
    public void calcPayments() {
        Stuff stuff = new Stuff();
        stuff.getStuffFromJson("./src/main/resources/stuff.json");
        stuff.createHeading();
        stuff.calcPayments();

        assertEquals(stuff.getAllEmployees().get(0).getPayment(),330000);
        assertEquals(stuff.getAllEmployees().get(1).getPayment(),36000);
        assertEquals(stuff.getAllEmployees().get(4).getPayment(),20000);
        assertEquals(stuff.getAllEmployees().get(7).getPayment(),70000);
        assertEquals(stuff.getAllEmployees().get(10).getPayment(),74000);
        assertEquals(stuff.getAllEmployees().get(13).getPayment(),90000);
        assertEquals(stuff.getAllEmployees().get(14).getPayment(),10000);
    }
}
