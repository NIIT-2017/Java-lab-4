import org.junit.Test;

import static org.junit.Assert.*;

public class TeamLeaderTest {

    @Test
    public void setPatePerEmployee() {
        int id = 23;
        String name = "Русаков Поликарп Андриянович";
        String position = "тимлидер";
        double share = 0.2;
        String project = "проект 1";
        double base = 600.0d;
        double rate = 3000.0d;
        int num = 5;
        double time = 40.0d;
        double delta = 0.0000001;
        TeamLeader tl = new TeamLeader(id, name, position, base, share, project, 0.0d, num);
        tl.setPatePerEmployee(rate);
        assertEquals(rate, tl.getRate(), delta);
    }

    @Test
    public void setEmployeeNum() {
        int id = 23;
        String name = "Русаков Поликарп Андриянович";
        String position = "тимлидер";
        double share = 0.2;
        String project = "проект 1";
        double base = 600.0d;
        double rate = 3000.0d;
        int num = 5;
        double time = 40.0d;
        TeamLeader tl = new TeamLeader(id, name, position, base, share, project, rate, 0);
        tl.setEmployeeNum(num);
        assertEquals(num, tl.getEmplNum());
    }

    @Test
    public void getRate() {
        int id = 23;
        String name = "Русаков Поликарп Андриянович";
        String position = "тимлидер";
        double share = 0.2;
        String project = "проект 1";
        double base = 600.0d;
        double rate = 4444.0d;
        int num = 5;
        double time = 40.0d;
        double delta = 0.0000001;
        TeamLeader tl = new TeamLeader(id, name, position, base, share, project, 0.0d, num);
        tl.setPatePerEmployee(rate);
        assertEquals(rate, tl.getRate(), delta);
    }

    @Test
    public void getEmplNum() {
        int id = 23;
        String name = "Русаков Поликарп Андриянович";
        String position = "тимлидер";
        double share = 0.2;
        String project = "проект 1";
        double base = 600.0d;
        double rate = 3000.0d;
        int num = 5;
        double time = 40.0d;
        TeamLeader tl = new TeamLeader(id, name, position, base, share, project, rate, 0);
        tl.setEmployeeNum(num);
        assertEquals(num, tl.getEmplNum());
    }

    @Test
    public void calcPaymentFromHeading() {
        int id = 23;
        String name = "Русаков Поликарп Андриянович";
        String position = "тимлидер";
        double share = 0.2;
        String project = "проект 1";
        double base = 600.0d;
        double rate = 3000.0d;
        int num = 5;
        double delta = 0.0000001;
        double time = 40.0d;
        TeamLeader tl = new TeamLeader(id, name, position, base, share, project, rate, num);
        assertEquals(num * rate, tl.calcPaymentFromHeading(), delta);
    }

    @Test
    public void calcPayment() {
        int id = 23;
        String name = "Русаков Поликарп Андриянович";
        String position = "тимлидер";
        double share = 0.2;
        String project = "проект 1";
        double base = 600.0d;
        double rate = 3000.0d;
        int num = 5;
        double delta = 0.0000001;
        double time = 40.0d;
        TeamLeader tl = new TeamLeader(id, name, position, base, share, project, rate, num);
        tl.setTime(time);
        tl.calcPayment();
        assertEquals(rate * num + share *DataLoader.getProjectBudgets(project) + base * time, tl.getPayment(), delta);
    }
}