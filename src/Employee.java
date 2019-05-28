abstract class Employee {

    private int id;
    private String name;
    private int worktime;
    private float payment;

    public Employee(int id, String name, int worktime, float payment) {
        this.id = id;
        this.name = name;
        this.worktime = worktime;
        this.payment = payment;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public int getWorktime() {
        return worktime;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    abstract public float calculateSalary();
}

interface WorkTime {
    float calculateSalaryForWorkTime();
}

interface Project {
    float calculateSalaryForProject();
}

interface Heading {
    float calculateSalaryForHeading();
}


