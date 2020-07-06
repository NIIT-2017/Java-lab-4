
public class Driver extends Employee implements WorkTime{
    String position;
    int businessTrip = (int) (Math.random() * 8);
    float bonusForBusinessTrip = 1000;

    public Driver (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Driver () {
    }

    public String getPosition() {
        return position;
    }
    public void setPosition (String position) {
        this.position = position;
    }

    protected int getBusinessTrip() {
        return businessTrip;
    }

    protected void setBusinessTrip(int businessTrip) {
        this.businessTrip = businessTrip;
    }

    @Override
    public float calculateSalary() {
        payment = (worktime * rate) + (float) businessTrip * bonusForBusinessTrip;;
        return payment;
    }
}
