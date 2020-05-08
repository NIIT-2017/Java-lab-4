public class TeamLeader extends Engineer implements Heading {
    int rate = 16750;
    int numberOfPeopleInProject;
    int overfulfilmentOfPlan = (int) (Math.random() *1);
    final int bonusForOverfulfilmentOfPlan = 30000;

    public TeamLeader (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public TeamLeader () {
    }

    public void setNumberOfPeopleInProject(int number) {
        this.numberOfPeopleInProject = number;
    }

    public int getNumberOfPeopleInProject() {
        return numberOfPeopleInProject;
    }

    public void setOverfulfilmentOfPlan(int zeroOrOne) {
        this.overfulfilmentOfPlan = zeroOrOne;
    }

    @Override
    public float calculateSalaryForHeading(int numberOfPeopleInProject) {
        //numberOfEmployees - 3 means that ProjectManager Team Leader and Manager isn`t counted
        payment = rate * (numberOfPeopleInProject - 3) + (overfulfilmentOfPlan * bonusForOverfulfilmentOfPlan);
        return payment;
    }

    @Override
    public float calculateSalaryForTheProject(float proportionOfParticipationInProject, float projectTermInMonths) {
        return 0;
    }
}
