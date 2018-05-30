import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DataLoaderTest {

    @Test
    public void getId() {
        ArrayList<DataLoader> arrdl = DataLoader.readInputData("data.json");
        assertEquals(1, arrdl.get(0).getId());
    }

    @Test
    public void getName() {
        ArrayList<DataLoader> arrdl = DataLoader.readInputData("data.json");
        assertEquals("Набоков Александр Эмилевич", arrdl.get(0).getName());
    }

    @Test
    public void getPosition() {
        ArrayList<DataLoader> arrdl = DataLoader.readInputData("data.json");
        assertEquals("старший менеджер", arrdl.get(0).getPosition());
    }

    @Test
    public void getBase() {
        ArrayList<DataLoader> arrdl = DataLoader.readInputData("data.json");
        double delta = 0.0000001;
        assertEquals(940.0d, arrdl.get(0).getBase(), delta);
    }

    @Test
    public void getProject() {
        ArrayList<DataLoader> arrdl = DataLoader.readInputData("data.json");
        assertEquals("все проекты", arrdl.get(0).getProject());
    }

    @Test
    public void getProjectBudgets() {
        String project = "проект 1";
        double delta = 0.0000001;
        assertEquals(300000.0d, DataLoader.getProjectBudgets(project), delta);
    }

    @Test
    public void createObj() {
        double delta = 0.0000001;
        ArrayList<DataLoader> arrdl = DataLoader.readInputData("data.json");
        Employee e1 = arrdl.get(1).createObj();
        assertEquals(2, e1.getId());
        assertEquals("Цыцын Денис Евграфович", e1.getName());
        assertEquals("менеджер проекта", e1.getPosition());
        assertEquals(0.0d, e1.getPayment(), delta);
        assertEquals(0.0d, e1.getTime(), delta);
    }

    @Test
    public void readInputData() {
        ArrayList<DataLoader> arrdl = DataLoader.readInputData("data.json");
        assertEquals(44, arrdl.size());
    }
}