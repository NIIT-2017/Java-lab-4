public class TeamLeader extends Programmer implements Heading {
    int countEmployee;
    float workTime;
    float base;

    public TeamLeader(int id, String name, float base, float bonus,int countEmployee) {
        super(id, name, base, bonus);
        this.countEmployee = countEmployee;
    }

    public float calcSalaryDependOfCountEmployee(int countEmployee) {
        return this.countEmployee * 1000;
    }

    @Override
    public float calcSalaryDependOfTime(float workTime, float base) {
        return this.workTime * this.base;
    }

    @Override
    protected float calcSalary() {
        this.payment = calcSalaryDependOfCountEmployee(this.countEmployee) + calcSalaryDependOfTime(this.workTime,this.base);
        return this.payment;
    }
}
