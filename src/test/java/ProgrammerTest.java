import org.junit.Test;

import static org.junit.Assert.*;

public class ProgrammerTest {

    @Test
    public void calcPaymentFromTime() {
        int id = 1;
        String name = "Разуваев Эдуард Моисеевич";
        String position = "программист";
        double base = 550.0d;
        double share = 0.02;
        String project = "проект 2";
        double time = 160.0d;
        double delta = 0.0000001;
        Programmer pr = new Programmer(id, name, position, base, share, project);
        pr.setTime(time);
        assertEquals(base * time, pr.calcPaymentFromTime(), delta);
    }

    @Test
    public void calcPaymentFromProject() {
        int id = 1;
        String name = "Разуваев Эдуард Моисеевич";
        String position = "программист";
        double base = 550.0d;
        double share = 0.02;
        String project = "проект 2";
        double delta = 0.0000001;
        Programmer pr = new Programmer(id, name, position, base, share, project);
        assertEquals(share * DataLoader.getProjectBudgets(project), pr.calcPaymentFromProject(), delta);
    }

    @Test
    public void calcPayment() {
        int id = 1;
        String name = "Разуваев Эдуард Моисеевич";
        String position = "программист";
        double base = 550.0d;
        double share = 0.02;
        String project = "проект 2";
        double time = 160.0d;
        double delta = 0.0000001;
        Programmer pr = new Programmer(id, name, position, base, share, project);
        pr.setTime(time);
        pr.calcPayment();
        assertEquals(share * DataLoader.getProjectBudgets(project) + base * time, pr.getPayment(), delta);
    }
}