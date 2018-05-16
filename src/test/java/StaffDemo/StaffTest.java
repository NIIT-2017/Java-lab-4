package StaffDemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StaffTest {
    private Staff staff;
    private ArrayList<Employee> employees;
    private Employee employee;

    private ArrayList<Project> projects;
    private Project project;
    @Before
    public void setUp() throws Exception {
        staff = new Staff();
        employees = new ArrayList<Employee>();
        employees.add(new Cleaner("Csurname","Cname","Csecondname"));
        employees.add(new Driver("Dsurname","Dname","Dsecondname"));
        employees.add(new ProjectManager("PMsurname","PMname","PMsecondname"));
        employees.add(new Programmer("Psurname","Pname","Psecondname"));
        employees.add(new Tester("Tsurname","Tname","Tsecond name"));
        employee = new SeniorManager("Ssurname", "Sname", "Ssecondname");

        projects = new ArrayList<Project>();
        projects.add(new Project("firstProject", 10000));
        projects.add(new Project("secondProject", 10000));
        projects.add(new Project("thirdProject", 10000));
        project = new Project("fourthProject", 10000);
    }

    @Test
    public void addEmployee() {
        assertFalse(staff.getEmployees().contains(employee));
        staff.addEmployee(employee);
        assertTrue(staff.getEmployees().contains(employee));
    }

    @Test
    public void addEmployeeNoNames() {
        assertFalse(staff.getEmployees().contains(employee));
        staff.addEmployee(new SeniorManager("","",""));
        assertFalse(staff.getEmployees().contains(employee));
    }

    @Test
    public void addEmployeeNoSurname() {
        assertFalse(staff.getEmployees().contains(employee));
        staff.addEmployee(new SeniorManager("","name","secondname"));
        assertFalse(staff.getEmployees().contains(employee));
    }

    @Test
    public void addEmployeeNoName() {
        assertFalse(staff.getEmployees().contains(employee));
        staff.addEmployee(new SeniorManager("surname","","secondname"));
        assertFalse(staff.getEmployees().contains(employee));
    }

    @Test
    public void addEmployeeNoSecondname() {
        assertFalse(staff.getEmployees().contains(employee));
        staff.addEmployee(new SeniorManager("surname","name",""));
        assertFalse(staff.getEmployees().contains(employee));
    }

    @Test
    public void addEmployeeNull() {
        this.employee = null;
        int count = staff.getEmployees().size();
        staff.addEmployee(this.employee);
        assertEquals(count,staff.getEmployees().size());
    }

    @Test
    public void addEmployees() {
        assertFalse(staff.getEmployees().containsAll(this.employees));
        staff.addEmployees(this.employees);
        assertTrue(staff.getEmployees().containsAll(this.employees));
    }

    @Test
    public void addEmployeesNull() {
        this.employees =null;
        int count = staff.getEmployees().size();
        staff.addEmployees(this.employees);
        assertEquals(count,staff.getEmployees().size());
    }

    @Test
    public void addProject() {
        assertFalse(staff.getProjects().contains(this.project));
        staff.addProject(this.project);
        assertTrue(staff.getProjects().contains(this.project));
    }

    @Test
    public void addProjectNull() {
        this.project = null;
        int count = staff.getProjects().size();
        staff.addProject(this.project);
        assertEquals(count,staff.getProjects().size());
    }

    @Test
    public void addProjectNoName() {
        this.project = new Project("",10000);
        int count = staff.getProjects().size();
        staff.addProject(this.project);
        assertEquals(count,staff.getProjects().size());
    }

    @Test
    public void addProjectBudgetLessZero() {
        this.project = new Project("firstProject",-1);
        int count = staff.getProjects().size();
        staff.addProject(this.project);
        assertEquals(count,staff.getProjects().size());
    }

    @Test
    public void addProjectBudgetLessZeroNoName() {
        this.project = new Project("",-1);
        int count = staff.getProjects().size();
        staff.addProject(this.project);
        assertEquals(count,staff.getProjects().size());
    }

    @Test
    public void addProjects() {
        assertFalse(staff.getProjects().containsAll(this.projects));
        staff.addProjects(this.projects);
        assertTrue(staff.getProjects().containsAll(this.projects));
    }

    @Test
    public void addProjectsNull() {
        this.projects = null;
        int count = staff.getProjects().size();
        staff.addProjects(this.projects);
        assertEquals(count,staff.getProjects().size());
    }
}