public class Manager extends Employee implements Project {
    String project;
    String position;
    final float percentOfBudget = 0.16f;
    float projectTermInMonths = (float) (Math.random() * 14+6);

    public Manager (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Manager () {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition (String position) {
        this.position = position;
    }

    public String getProject() {
        return project;
    }

    public void setProject (String project) {
        this.project = project;
    }

    protected float getProportionOfParticipationInProject(float budget) {
        float proportionOfParticipationInProject = budget * percentOfBudget;
        return proportionOfParticipationInProject;
    }

    @Override
    public float getprojectTermInMonths() {
        return projectTermInMonths;
    }

    public void setProjectTermInMonths(float months) {
        this.projectTermInMonths = months;
    }

    @Override
    public float calculateSalaryForTheProject(float proportionOfParticipationInProject, float projectTermInMonths) {
        payment = proportionOfParticipationInProject/projectTermInMonths;
        return payment;
    }
}
