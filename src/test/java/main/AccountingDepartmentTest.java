package main;

import accounting_department.AccountingDepartment;
import employee.Employee;
import employee.engineer.TeamLeader;
import employee.engineer.Tester;
import employee.manager.Manager;
import employee.manager.SeniorManager;
import employee.personal.Cleaner;
import org.junit.Before;

import static org.junit.Assert.*;

public class AccountingDepartmentTest {

    private AccountingDepartment accountingDepartment;

    @Before
    public void init(){
        accountingDepartment = new AccountingDepartment();
    }

    @org.junit.Test
    public void getPaymentPersonal() throws Exception {
        Employee personal = new Cleaner();
        personal.setWorkTime(10);
        personal.setBase(10);
        personal.setPosition("Уборщица");
        double rez = accountingDepartment.getPayment(personal);
        assertEquals(100, rez, 0.1);
    }

    @org.junit.Test
    public void getPaymentEngineer() throws Exception {
        Employee engineer = new Tester();
        engineer.setWorkTime(10);
        engineer.setBase(10);
        engineer.setProject("StaffDemo", new Double[]{10.0, 0.5});
        engineer.setPosition("Инженер по тестированию");
        double rez = accountingDepartment.getPayment(engineer);
        assertEquals(105, rez, 0.1);
    }

    @org.junit.Test
    public void getPaymentManager() throws Exception {
        Employee manager = new Manager();
        manager.setProject("StaffDemo", new Double[]{100.0, 0.5});
        manager.setPosition("Менеджер");
        double rez = accountingDepartment.getPayment(manager);
        assertEquals(50, rez, 0.1);
    }

    @org.junit.Test
    public void getPaymentTeamLeader() throws Exception {
        Employee teamLeader = new TeamLeader();
        teamLeader.setWorkTime(10);
        teamLeader.setBase(10);
        teamLeader.setProject("StaffDemo", new Double[]{10.0, 0.5});
        teamLeader.setPosition("Ведущий программист");
        teamLeader.setSubordinates(1);
        double rez = accountingDepartment.getPayment(teamLeader);
        assertEquals(100105, rez, 0.1);
    }

    @org.junit.Test
    public void getSeniorManager() throws Exception {
        Employee seniorManager = new SeniorManager();
        seniorManager.setProject("StaffDemo", new Double[]{10.0, 0.5});
        seniorManager.setPosition("Ведущий программист");
        seniorManager.setSubordinates(1);
        double rez = accountingDepartment.getPayment(seniorManager);
        assertEquals(100005, rez, 0.1);
    }
}