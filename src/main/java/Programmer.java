
public class Programmer extends Engineer implements WorkTime{
    int numberOfPeopleInProject;
    float overtimeWork = (int) (Math.random() * 1);
    float bonusForOvertimeWork = 20000;
    float percentOfBudgetForAllPromrammers = (float) 0.54;

    public Programmer (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Programmer () {
    }

    public void setNumberOfPeopleInProject(int number) {
        this.numberOfPeopleInProject = number;
    }

    public int getNumberOfPeopleInProject() {
        return numberOfPeopleInProject;
    }

    public void setOvertimeWork(int zeroOrOne) {
        this.overtimeWork = zeroOrOne;
    }

    @Override
    public float calculateSalaryForWorkedTime() {
        paymentWT = worktime * rate + (overtimeWork * bonusForOvertimeWork);
        return paymentWT;
    }

    protected float getProportionOfParticipationInProject(float budget, int numberOfProgrammersInProject) {
        float proportionOfParticipationInProject = (budget * percentOfBudgetForAllPromrammers) / numberOfProgrammersInProject;
        return proportionOfParticipationInProject;
    }

    @Override
    public float calculateSalaryForTheProject(float proportionOfParticipationInProject, float projectTermInMonths) {
        paymentPR = proportionOfParticipationInProject / projectTermInMonths;
        return paymentPR;
    }
}
