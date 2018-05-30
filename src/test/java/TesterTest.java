import org.junit.Test;

import static org.junit.Assert.*;

public class TesterTest {

    @Test
    public void calcPaymentFromTime() {
        int id = 15;
        String name = "Марков Герасим Федотович";
        String position = "тестер";
        double base = 400.0d;
        double share = 0.01;
        String project = "проект 1";
        double time = 40.0d;
        double delta = 0.0000001;
        Tester ts = new Tester(id, name, position, base, share, project);
        ts.setTime(time);
        assertEquals(base * time, ts.calcPaymentFromTime(), delta);
    }

    @Test
    public void calcPaymentFromProject() {
        int id = 15;
        String name = "Марков Герасим Федотович";
        String position = "тестер";
        double base = 400.0d;
        double share = 0.01;
        String project = "проект 1";
        double time = 40.0d;
        double delta = 0.0000001;
        Tester ts = new Tester(id, name, position, base, share, project);
        assertEquals(share * DataLoader.getProjectBudgets(project), ts.calcPaymentFromProject(), delta);
    }

    @Test
    public void calcPayment() {
        int id = 15;
        String name = "Марков Герасим Федотович";
        String position = "тестер";
        double base = 400.0d;
        double share = 0.01;
        String project = "проект 1";
        double time = 40.0d;
        double delta = 0.0000001;
        Tester ts = new Tester(id, name, position, base, share, project);
        ts.setTime(time);
        ts.calcPayment();
        assertEquals(share * DataLoader.getProjectBudgets(project) + base * time, ts.getPayment(), delta);
    }
}