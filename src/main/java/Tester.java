public class Tester extends Engineer {
    public Tester(int id, String name, float base, float bonus) {
        super(id, name, base, bonus);
    }

    public float calcSalaryDependOfShare() {
        return this.bonus * (float)0.2;
    }

    protected float calcSalary() {
        this.payment = calcSalaryDependOfTime(this.worktime,this.base) + calcSalaryDependOfShare();
        return this.payment;
    }
}
