import java.util.ArrayList;

public class ProjectManager extends Manager implements Heading {
    String position;
    int numberOfPeopleInProject;
    float rate = 18000;

    public ProjectManager (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public ProjectManager () {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition (String position) {
        this.position = position;
    }

    public void setNumberOfPeopleInProject(int number) {
        this.numberOfPeopleInProject = number;
    }

    public int getNumberOfPeopleInProject() {
        return numberOfPeopleInProject;
    }

    @Override
    public float calculateSalaryForHeading(int numberOfPeopleInProject) {
        //(numberOfPeopleInProject - 1) means that ProjectManager isn`t counted
        payment = rate * (numberOfPeopleInProject - 1);
        return payment;
    }

    public float calculateSalaryForTheProject(float proportionOfParticipationInProject, float projectTermInMonths) {
        return 0;
    }
}
