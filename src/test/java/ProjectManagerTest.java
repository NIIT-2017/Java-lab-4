import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectManagerTest {

    @Test
    public void setPatePerEmployee() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер проекта";
        double share = 0.2;
        String project = "проект 1";
        double rate = 3500.0d;
        int num = 10;
        double delta = 0.0000001;
        ProjectManager pman = new ProjectManager(id, name, position, share, project, 0.0, num);
        pman.setPatePerEmployee(rate);
        assertEquals(rate, pman.getRate(), delta);

    }

    @Test
    public void setEmployeeNum() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер проекта";
        double share = 0.2;
        String project = "проект 1";
        double rate = 3500.0d;
        int num = 10;
        double delta = 0.0000001;
        ProjectManager pman = new ProjectManager(id, name, position, share, project, rate, 0);
        pman.setEmployeeNum(num);
        assertEquals(num, pman.getEmplNum());
    }

    @Test
    public void getRate() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер проекта";
        double share = 0.2;
        String project = "проект 1";
        double rate = 3333.0d;
        int num = 10;
        double delta = 0.0000001;
        ProjectManager pman = new ProjectManager(id, name, position, share, project, 0.0, num);
        pman.setPatePerEmployee(rate);
        assertEquals(rate, pman.getRate(), delta);
    }

    @Test
    public void getEmplNum() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер проекта";
        double share = 0.2;
        String project = "проект 1";
        double rate = 3500.0d;
        int num = 13;
        double delta = 0.0000001;
        ProjectManager pman = new ProjectManager(id, name, position, share, project, rate, 0);
        pman.setEmployeeNum(num);
        assertEquals(num, pman.getEmplNum());
    }

    @Test
    public void calcPaymentFromHeading() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер проекта";
        double share = 0.2;
        String project = "проект 1";
        double rate = 3500.0d;
        int num = 10;
        double delta = 0.0000001;
        ProjectManager pman = new ProjectManager(id, name, position, share, project, rate, num);
        assertEquals(rate * num, pman.calcPaymentFromHeading(), delta);
    }

    @Test
    public void calcPayment() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер проекта";
        double share = 0.2;
        String project = "проект 1";
        double rate = 3500.0d;
        int num = 10;
        double delta = 0.0000001;
        ProjectManager pman = new ProjectManager(id, name, position, share, project, rate, num);
        pman.calcPayment();
        assertEquals(rate * num + share *DataLoader.getProjectBudgets(project), pman.getPayment(), delta);
    }
}