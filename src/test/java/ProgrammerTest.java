import org.junit.Test;

import static org.junit.Assert.*;

public class ProgrammerTest {
    Programmer testPr = new Programmer("Петухов Евдоким Анатолиевич", 59);

    @Test
    public void calculateSalaryForWorkedTime() {
        testPr.setWorktime(124);
        testPr.setRate(900);
        assertEquals(111600, testPr.calculateSalaryForWorkedTime(), 0.01);
    }

    @Test
    public void calculateSalaryForWorkedTime1() {
        testPr.setWorktime(116);
        testPr.setRate(900);
        testPr.setOvertimeWork(1);
        assertEquals(124400, testPr.calculateSalaryForWorkedTime(), 0.01);
    }

    @Test
    public void getProportionOfParticipationInProject() {
        testPr.setNumberOfPeopleInProject(10);
        int numberOfProgrammersInProject = testPr.getNumberOfPeopleInProject();
        float budget = 1600000;
        assertEquals(86400, testPr.getProportionOfParticipationInProject(budget, numberOfProgrammersInProject), 0.01);
    }

    @Test
    public void getProportionOfParticipationInProject1() {
        testPr.setNumberOfPeopleInProject(20);
        int numberOfProgrammersInProject = testPr.getNumberOfPeopleInProject();
        float budget = 4800000;
        assertEquals(129600, testPr.getProportionOfParticipationInProject(budget, numberOfProgrammersInProject), 0.01);
    }

    @Test
    public void calculateSalaryForTheProject() {
        testPr.setProjectTermInMonths(8);
        float months = testPr.getprojectTermInMonths();
        testPr.setNumberOfPeopleInProject(20);
        int numberOfProgrammersInProject = testPr.getNumberOfPeopleInProject();
        float budget = 4800000;
        float proportionOfParticipationInProject = testPr.getProportionOfParticipationInProject(budget, numberOfProgrammersInProject);
        assertEquals(16200, testPr.calculateSalaryForTheProject(proportionOfParticipationInProject, months), 0.01);
    }

    @Test
    public void calculateSalaryForTheProject1() {
        testPr.setProjectTermInMonths(6);
        float months = testPr.getprojectTermInMonths();
        testPr.setNumberOfPeopleInProject(10);
        int numberOfProgrammersInProject = testPr.getNumberOfPeopleInProject();
        float budget = 1600000;
        float proportionOfParticipationInProject = testPr.getProportionOfParticipationInProject(budget, numberOfProgrammersInProject);
        assertEquals(14400, testPr.calculateSalaryForTheProject(proportionOfParticipationInProject, months), 0.01);
    }

    @Test
    public void calculateSalary() {
        testPr.setWorktime(116);
        testPr.setRate(900);
        testPr.setOvertimeWork(1);
        testPr.calculateSalaryForWorkedTime();
        testPr.setProjectTermInMonths(6);
        testPr.setNumberOfPeopleInProject(10);
        int numberOfProgrammersInProject = testPr.getNumberOfPeopleInProject();
        float budget = 1600000;
        float proportionOfParticipationInProject = testPr.getProportionOfParticipationInProject(budget, numberOfProgrammersInProject);
        testPr.calculateSalaryForTheProject(proportionOfParticipationInProject, testPr.getprojectTermInMonths());
        assertEquals(138800, testPr.calculateSalary(), 0.01);
    }

}