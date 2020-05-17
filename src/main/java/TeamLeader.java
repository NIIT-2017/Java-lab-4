public class TeamLeader extends Engineer implements Heading {
    float rateHeading = 5000;
    protected float paymentH;
    float percentOfBudget =  (float) 0.02;
    int numberOfPeopleInProject;
    int overfulfilmentOfPlan = (int) (Math.random() *1);
    final int bonusForOverfulfilmentOfPlan = 30000;

    public TeamLeader (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public TeamLeader () {
    }

    public float getRateHeading() {
        return rateHeading;
    }

    public void setRateHeading(float rateHeading) {
        this.rateHeading = rateHeading;
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
        paymentH = rateHeading  * (numberOfPeopleInProject - 3);
        return paymentH;
    }

    @Override
    public float calculateSalaryForWorkedTime() {
        paymentWT = worktime * rate + (overfulfilmentOfPlan * bonusForOverfulfilmentOfPlan);
        return paymentWT;
    }

    protected float getProportionOfParticipationInProject(float budget) {
        float proportionOfParticipationInProject = budget * percentOfBudget;
        return proportionOfParticipationInProject;
    }

    @Override
    public float calculateSalaryForTheProject(float proportionOfParticipationInProject, float projectTermInMonths) {
        paymentPR = proportionOfParticipationInProject / projectTermInMonths;
        return paymentPR;
    }

    @Override
    public float calculateSalary() {
        payment = paymentWT + paymentPR + paymentH;
        return payment;
    }

}
