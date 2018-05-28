import java.util.ArrayList;
import static org.junit.Assert.*;

public class HRTest
{
    private String
        gInfo = "--------------------------------------------------------------------------------------------------------------------------\n" +
                "| ID       | FULLNAME                               | POSITION           | WORKTIME | PROJECT            | SALARY        |\n" +
                "--------------------------------------------------------------------------------------------------------------------------\n";

    @org.junit.Test
    public void hr() {
        HR.work();
        assertEquals(false, HR.getInfo().equals(gInfo));
    }

    @org.junit.Test
    public void getInfo() {
        HR.Test.init();
        assertEquals(gInfo, HR.getInfo());
    }

    @org.junit.Test
    public void newDraft1() {
        HR.Test.init();
        assertEquals(true, HR.Test.newDraft("Proj", 1000));
    }
    @org.junit.Test
    public void newDraft2() {
        HR.Test.init();
        assertEquals(false, HR.Test.newDraft("", 1000));
    }
    @org.junit.Test
    public void newDraft3() {
        HR.Test.init();
        assertEquals(false, HR.Test.newDraft("Proj", 0));
    }

    @org.junit.Test
    public void newEmployee1() {
        HR.Test.init();
        assertEquals(true, HR.Test.newEmployee(147, "Ivanov Ivan Ivanovich", "DRIVER", 120, "NULL"));
    }
    @org.junit.Test
    public void newEmployee2() {
        HR.Test.init();
        assertEquals(false, HR.Test.newEmployee(147, "Ivanov Ivan Ivanovich", "Tester", 120, "NULL"));
    }
    @org.junit.Test
    public void newEmployee3() {
        HR.Test.init();
        assertEquals(false, HR.Test.newEmployee(0, "Ivanov Ivan Ivanovich", "Tester", 120, "NULL"));
    }

    @org.junit.Test
    public void getEmployeesCountOfAllProjects() {
        HR.Test.init();
        assertEquals(0, HR.getEmployeesCountOfAllProjects(), 0.01);
    }

    @org.junit.Test
    public void getEmployeesCountOfProjectByTitle1() {
        assertEquals(0, HR.getEmployeesCountOfProjectByTitle("proj"), 0.01);
    }
    @org.junit.Test
    public void getEmployeesCountOfProjectByTitle2() {
        assertEquals(0, HR.getEmployeesCountOfProjectByTitle(null), 0.01);
    }
    @org.junit.Test
    public void getEmployeesCountOfProjectByTitle3() {
        assertEquals(0, HR.getEmployeesCountOfProjectByTitle(""), 0.01);
    }

    @org.junit.Test
    public void getProgrammersCountOfProject1() {
        assertEquals(0, HR.getProgrammersCountOfProject("proj"), 0.01);
    }
    @org.junit.Test
    public void getProgrammersCountOfProject2() {
        assertEquals(0, HR.getProgrammersCountOfProject(null), 0.01);
    }
    @org.junit.Test
    public void getProgrammersCountOfProject3() {
        assertEquals(0, HR.getProgrammersCountOfProject(""), 0.01);
    }

    @org.junit.Test
    public void getSeniorRate() {
        assertEquals(0, HR.getSeniorRate(), 0.01);
    }

    @org.junit.Test
    public void getProjectRate1() {
        assertEquals(0, HR.getProjectRate("proj"), 0.01);
    }
    @org.junit.Test
    public void getProjectRate2() {
        assertEquals(0, HR.getProjectRate(""), 0.01);
    }
    @org.junit.Test
    public void getProjectRate3() {
        assertEquals(0, HR.getProjectRate(null), 0.01);
    }

    @org.junit.Test
    public void getProjectBudget1() {
        assertEquals(0, HR.Test.getProjectBudget("proj"), 0.01);
    }
    @org.junit.Test
    public void getProjectBudget2() {
        assertEquals(0, HR.Test.getProjectBudget(""), 0.01);
    }
    @org.junit.Test
    public void getProjectBudget3() {
        assertEquals(0, HR.Test.getProjectBudget(null), 0.01);
    }

    @org.junit.Test
    public void getAllProjectsBudget() {
        HR.Test.init();
        assertEquals(0, HR.Test.getAllProjectsBudget(), 0.01);
    }

    @org.junit.Test
    public void getAllProjectsCount() {
        HR.Test.init();
        assertEquals(0, HR.Test.getAllProjectsCount(), 0.01);
    }

    @org.junit.Test
    public void getAllWorkTime() {
        HR.Test.init();
        assertEquals(0, HR.Test.getAllWorkTime(), 0.01);
    }

    @org.junit.Test
    public void getWorkTimeProject1() {
        assertEquals(0, HR.Test.getWorkTimeProject("Proj"), 0.01);
    }
    @org.junit.Test
    public void getWorkTimeProject2() {
        assertEquals(0, HR.Test.getWorkTimeProject(null), 0.01);
    }
    @org.junit.Test
    public void getWorkTimeProject3() {
        assertEquals(0, HR.Test.getWorkTimeProject(""), 0.01);
    }

    @org.junit.Test
    public void getEmployeeById1() {
        HR.Test.init();
        assertEquals(null, HR.Test.getEmployeeById(159));
    }
    @org.junit.Test
    public void getEmployeeById2() {
        assertEquals(null, HR.Test.getEmployeeById(0));
    }
    @org.junit.Test
    public void getEmployeeById3() {
        assertEquals(null, HR.Test.getEmployeeById(-100));
    }

    @org.junit.Test
    public void getDraftByTitle1() {
        assertEquals(null, HR.Test.getDraftByTitle("Proj"));
    }
    @org.junit.Test
    public void getDraftByTitle2() {
        assertEquals(null, HR.Test.getDraftByTitle(null));
    }
    @org.junit.Test
    public void getDraftByTitle3() {
        assertEquals(null, HR.Test.getDraftByTitle(""));
    }

    @org.junit.Test
    public void checkDraftByTitle1() {
        assertEquals(false, HR.Test.checkDraftByTitle("Proj"));
    }
    @org.junit.Test
    public void checkDraftByTitle2() {
        assertEquals(false, HR.Test.checkDraftByTitle(null));
    }
    @org.junit.Test
    public void checkDraftByTitle3() {
        assertEquals(false, HR.Test.checkDraftByTitle(""));
    }

    @org.junit.Test
    public void checkNoSeniorManager1() {
        HR.Test.init();
        assertEquals(true, HR.Test.checkNoSeniorManager());
    }

    @org.junit.Test
    public void checkNoProjectManager1() {
        Draft draft = new Draft("Draft", 1000);
        assertEquals(true, HR.Test.checkNoProjectManager(draft));
    }
    @org.junit.Test
    public void checkNoProjectManager2() {
        Draft draft = new Draft("", 1000);
        assertEquals(true, HR.Test.checkNoProjectManager(draft));
    }
    @org.junit.Test
    public void checkNoProjectManager3() {
        Draft draft = new Draft("Draft", 0);
        assertEquals(true, HR.Test.checkNoProjectManager(draft));
    }

    @org.junit.Test
    public void checkNoEmployeeOfProjects1() {
        HR.Test.init();
        assertEquals(true, HR.Test.checkNoEmployeeOfProjects(123));
    }
    @org.junit.Test
    public void checkNoEmployeeOfProjects2() {
        assertEquals(true, HR.Test.checkNoEmployeeOfProjects(-123));
    }
    @org.junit.Test
    public void checkNoEmployeeOfProjects3() {
        assertEquals(true, HR.Test.checkNoEmployeeOfProjects(0));
    }

    @org.junit.Test
    public void checkNoEmployeeId1() {
        HR.Test.init();
        assertEquals(true, HR.Test.checkNoEmployeeId(123));
    }
    @org.junit.Test
    public void checkNoEmployeeId2() {
        assertEquals(true, HR.Test.checkNoEmployeeId(0));
    }
    @org.junit.Test
    public void checkNoEmployeeId3() {
        assertEquals(true, HR.Test.checkNoEmployeeId(-100));
    }

    @org.junit.Test
    public void checkDraftData1() {
        assertEquals(true, HR.Test.checkDraftData("Proj", 1000));
    }
    @org.junit.Test
    public void checkDraftData2() {
        assertEquals(false, HR.Test.checkDraftData("", 1000));
    }
    @org.junit.Test
    public void checkDraftData3() {
        assertEquals(false, HR.Test.checkDraftData("Proj", 0));
    }

    @org.junit.Test
    public void checkEmployeeData1() {
        assertEquals(true, HR.Test.checkEmployeeData(120, "Ivanov Ivan Ivanovich", "Driver", 180, "null"));
    }
    @org.junit.Test
    public void checkEmployeeData2() {
        assertEquals(false, HR.Test.checkEmployeeData(0, "Ivanov Ivan Ivanovich", "Driver", 180, "null"));
    }
    @org.junit.Test
    public void checkEmployeeData3() {
        assertEquals(false, HR.Test.checkEmployeeData(120, "", "Driver", 180, "null"));
    }
    @org.junit.Test
    public void checkEmployeeData4() {
        assertEquals(false, HR.Test.checkEmployeeData(120, "Ivanov Ivan Ivanovich", "", 180, "null"));
    }
    @org.junit.Test
    public void checkEmployeeData5() {
        assertEquals(false, HR.Test.checkEmployeeData(120, "Ivanov Ivan Ivanovich", "Driver", -1, "null"));
    }
    @org.junit.Test
    public void checkEmployeeData6() {
        assertEquals(false, HR.Test.checkEmployeeData(120, "Ivanov Ivan Ivanovich", "Driver", 180, ""));
    }

    @org.junit.Test
    public void checkDraftsNotNull() {
        HR.Test.init();
        assertEquals(true, HR.Test.checkDraftsNotNull());
    }
    @org.junit.Test
    public void checkEmployeesNotNull() {
        HR.Test.init();
        assertEquals(true, HR.Test.checkEmployeesNotNull());
    }

    @org.junit.Test
    public void notNullDraft1() {
        assertEquals(false, HR.Test.notNullDraft(null));
    }
    @org.junit.Test
    public void notNullDraft2() {
        Draft draft = new Draft("Project", 1000);
        assertEquals(true, HR.Test.notNullDraft(draft));
    }
    @org.junit.Test
    public void notNullDraft3() {
        assertEquals(true, HR.Test.notNullDraft(new Draft("Project", 1000)));
    }

    @org.junit.Test
    public void notNullEmployee1() {
        assertEquals(false, HR.Test.notNullEmployee(null));
    }
    @org.junit.Test
    public void notNullEmployee2() {
        Employee employee = new Cleaner();
        assertEquals(true, HR.Test.notNullEmployee(employee));
    }
    @org.junit.Test
    public void notNullEmployee3() {
        assertEquals(true, HR.Test.notNullEmployee(new Cleaner()));
    }

    @org.junit.Test
    public void notNullIdEmployees1() {
        assertEquals(false, HR.Test.notNullIdEmployees(null));
    }
    @org.junit.Test
    public void notNullIdEmployees2() {
        ArrayList<Integer> idEmployees = new ArrayList<Integer>();
        assertEquals(true, HR.Test.notNullIdEmployees(idEmployees));
    }
    @org.junit.Test
    public void notNullIdEmployees3() {
        ArrayList<Integer> idEmployees = new ArrayList<Integer>();
        idEmployees.add(123);
        assertEquals(true, HR.Test.notNullIdEmployees(idEmployees));
    }

    @org.junit.Test
    public void notNullAndNotEmptyString1() {
        assertEquals(false, HR.Test.notNullAndNotEmptyString(null));
    }
    @org.junit.Test
    public void notNullAndNotEmptyString2() {
        assertEquals(false, HR.Test.notNullAndNotEmptyString(""));
    }
    @org.junit.Test
    public void notNullAndNotEmptyString3() {
        assertEquals(true, HR.Test.notNullAndNotEmptyString("null"));
    }
}
