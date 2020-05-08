import org.junit.Test;

import static org.junit.Assert.*;

public class TesterTest {
    Tester testT = new Tester("Туров Юлий Вадимович", 60);

    @Test
    public void calculateSalaryForProject () {
        testT.setWorktime(160);
        testT.setRate(650);
        testT.setDiscoveredSeriousBug(2);
        assertEquals(110000, testT.calculateSalaryForWorkedTime(), 0.01);
    }

    @Test
    public void calculateSalaryForProject1() {
        testT.setWorktime(104);
        testT.setRate(650);
        testT.setDiscoveredSeriousBug(0);
        assertEquals(67600, testT.calculateSalaryForWorkedTime(), 0.01);
    }

    @Test
    public void getProportionOfParticipationInProject() {
        testT.setNumberOfPeopleInProject(8);
        int numberOfProgrammersInProject = testT.getNumberOfPeopleInProject();
        float budget = 1600000;
        assertEquals(48000, testT.getProportionOfParticipationInProject(budget, numberOfProgrammersInProject), 0.01 );
    }

    @Test
    public void getProportionOfParticipationInProject1() {
        testT.setNumberOfPeopleInProject(6);
        int numberOfProgrammersInProject = testT.getNumberOfPeopleInProject();
        float budget = 2200000;
        assertEquals(88000, testT.getProportionOfParticipationInProject(budget, numberOfProgrammersInProject), 0.01 );
    }

    @Test
    public void calculateSalaryForTheProject() {
        testT.setProjectTermInMonths(8);
        float months = testT.getprojectTermInMonths();
        testT.setNumberOfPeopleInProject(8);
        int numberOfProgrammersInProject = testT.getNumberOfPeopleInProject();
        float budget = 1600000;
        float  proportionOfParticipationInProject = testT.getProportionOfParticipationInProject(budget, numberOfProgrammersInProject);
        assertEquals(6000, testT.calculateSalaryForTheProject(proportionOfParticipationInProject, months), 0.01);
    }

    @Test
    public void calculateSalaryForTheProject1() {
        testT.setProjectTermInMonths(11);
        float months = testT.getprojectTermInMonths();
        testT.setNumberOfPeopleInProject(6);
        int numberOfProgrammersInProject = testT.getNumberOfPeopleInProject();
        float budget = 2200000;
        float  proportionOfParticipationInProject = testT.getProportionOfParticipationInProject(budget, numberOfProgrammersInProject);
        assertEquals(8000, testT.calculateSalaryForTheProject(proportionOfParticipationInProject, months), 0.01);
    }

    @Test
    public void calculateSalary() {
        testT.setWorktime(160);
        testT.setRate(650);
        testT.setDiscoveredSeriousBug(2);
        testT.calculateSalaryForWorkedTime();
        testT.setProjectTermInMonths(8);
        float months = testT.getprojectTermInMonths();
        testT.setNumberOfPeopleInProject(8);
        int numberOfProgrammersInProject = testT.getNumberOfPeopleInProject();
        float budget = 1600000;
        float  proportionOfParticipationInProject = testT.getProportionOfParticipationInProject(budget, numberOfProgrammersInProject);
        testT.calculateSalaryForTheProject(proportionOfParticipationInProject, months);
        assertEquals(116000, testT.calculateSalary(), 0.01);
    }
}