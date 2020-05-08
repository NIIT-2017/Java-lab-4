public class SeniorManager extends ProjectManager {
    String position;
    float rate = 10000;
    int numberOfPeopleInCompany;

    public SeniorManager (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public SeniorManager () {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition (String position) {
        this.position = position;
    }

    public void setNumberOfPeopleInCompany (int number) {
        this.numberOfPeopleInCompany=number;
    }

    public int getNumberOfPeopleInCompany () {
        return numberOfPeopleInCompany;
    }

    @Override
    public float calculateSalaryForHeading(int numberOfPeopleInCompany ) {
        //(numberOfPeopleInCompany  - 1) means that ProjectManager isn`t counted
        payment = rate * (numberOfPeopleInCompany  - 1);
        return payment;
    }

}
