import java.math.RoundingMode;

public abstract class Engineer extends Employee implements Project, WorkTime {
    String position;
    protected float paymentWT;
    protected float paymentPR;
    String project;
    float projectTermInMonths;

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

    public float calculateSalaryForWorkedTime() {
        paymentWT = super.worktime * rate;
        return paymentWT;
    }

    public void setProjectTermInMonths(float months) {
        this.projectTermInMonths = months;
    }

    @Override
    public float getprojectTermInMonths() {
        return projectTermInMonths;
    }

    @Override
    public float calculateSalary() {
        payment = paymentWT + paymentPR;
        return payment;
    }
}
