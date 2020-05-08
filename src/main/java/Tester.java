
public class Tester extends Engineer implements WorkTime {
    int discoveredSeriousBug = (int) (Math.random() * 4);
    final int bonusFordiscoveredSeriousBug = 3000;
    int numberOfPeopleInProject;
    float percentOfBudgetForAllTesters =  (float) 0.24;

    public Tester (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Tester () {
    }

    public void setDiscoveredSeriousBug (int seriousBug) {
        this.discoveredSeriousBug = seriousBug;
    }

    public int getDiscoveredSeriousBug() {
        return discoveredSeriousBug;
    }

    public void setNumberOfPeopleInProject(int number) {
        this.numberOfPeopleInProject = number;
    }

    public int getNumberOfPeopleInProject() {
        return numberOfPeopleInProject;
    }

    public float calculateSalaryForWorkedTime() {
        paymentWT = worktime * rate + (discoveredSeriousBug * bonusFordiscoveredSeriousBug);
        return paymentWT;
    }

    protected float getProportionOfParticipationInProject(float budget, int numberOfTestersInProject) {
        float proportionOfParticipationInProject = (budget * percentOfBudgetForAllTesters) / numberOfTestersInProject;
        return proportionOfParticipationInProject;
    }

    @Override
    public float calculateSalaryForTheProject(float proportionOfParticipationInProject, float projectTermInMonths) {
        paymentPR = proportionOfParticipationInProject / projectTermInMonths;
        return paymentPR;
    }

}