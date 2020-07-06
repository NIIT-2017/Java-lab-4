import Employees.Engineer;
import Employees.Project;
import org.junit.Test;

import static org.junit.Assert.*;
public class EmployeeTests {
    @Test
    public void SalaryEngineerTimeTest() throws Exception
    {
        int salaryForHour=300;
        Engineer engineer=CreatorForTests.createEngineer(Engineer.class,salaryForHour);
        int hours=100;
        engineer.setWorkTime(hours);
        assertEquals(salaryForHour*hours,engineer.getSalary());
    }
    @Test
    public void SalaryEngineerProjectTest() throws Exception
    {
        Project project=CreatorForTests.createProject();
        int salaryForHour=300;
        Engineer engineer=CreatorForTests.createEngineer(Engineer.class,salaryForHour);
        int hours=100;
        engineer.setWorkTime(hours);
        engineer.setProject(project);
        project.generateEmployeesPartitionPoints();
        long participationPoints=project.getEmployeeParticipationPoints(engineer);
        long salaryForParticipation=participationPoints*project.getParticipationPointSalary();
        assertEquals(salaryForHour*hours+engineer.getSalaryForParticipation(),engineer.getSalary());
    }
}
