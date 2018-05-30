import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void setShare() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(id, name, position, 0, project);
        man.setShare(share);
        assertEquals(share, man.getShare(), delta);
    }

    @Test
    public void setProject() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(id, name, position, share, "");
        man.setProject(project);
        assertEquals(project, man.getProject());
    }

    @Test
    public void getShare() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.33;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(id, name, position, 0, project);
        man.setShare(share);
        assertEquals(share, man.getShare(), delta);
    }

    @Test
    public void getProject() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 2";
        double delta = 0.0000001;
        Manager man = new Manager(id, name, position, share, "");
        man.setProject(project);
        assertEquals(project, man.getProject());
    }

    @Test
    public void calcPaymentFromProject() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(id, name, position, share, project);
        assertEquals(share * DataLoader.getProjectBudgets(project), man.calcPaymentFromProject(), delta);
    }

    @Test
    public void calcPayment() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(id, name, position, share, project);
        man.calcPayment();
        assertEquals(share * DataLoader.getProjectBudgets(project), man.getPayment(), delta);
    }

    @Test
    public void setId() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(0, name, position, share, project);
        man.setId(id);
        assertEquals(id, man.getId());
    }

    @Test
    public void setName() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(id, "", position, share, project);
        man.setName(name);
        assertEquals(name, man.getName());
    }

    @Test
    public void setPosition() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(id, name, "", share, project);
        man.setPosition(position);
        assertEquals(position, man.getPosition());
    }

    @Test
    public void setTime() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(id, name, position, share, project);
        double time = 40.0d;
        man.setTime(time);
        assertEquals(time, man.getTime(), delta);
    }

    @Test
    public void getId() {
        int id = 2;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(0, name, position, share, project);
        man.setId(id);
        assertEquals(id, man.getId());
    }

    @Test
    public void getName() {
        int id = 1;
        String name = "Самохин Семён Михаилович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(id, "", position, share, project);
        man.setName(name);
        assertEquals(name, man.getName());
   }

    @Test
    public void getPosition() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(id, name, "", share, project);
        man.setPosition(position);
        assertEquals(position, man.getPosition());
    }

    @Test
    public void getTime() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(id, name, position, share, project);
        double time = 40.0d * 4.0;
        man.setTime(time);
        assertEquals(time, man.getTime(), delta);
    }

    @Test
    public void getPayment() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.2;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(id, name, position, share, project);
        man.calcPayment();
        assertEquals(share * DataLoader.getProjectBudgets(project), man.getPayment(), delta);
    }

    @Test
    public void calcPayment1() {
        int id = 1;
        String name = "Кандинский Леондий Иванович";
        String position = "менеджер";
        double share = 0.333;
        String project = "проект 1";
        double delta = 0.0000001;
        Manager man = new Manager(id, name, position, share, project);
        man.calcPayment();
        assertEquals(share * DataLoader.getProjectBudgets(project), man.getPayment(), delta);
    }
}