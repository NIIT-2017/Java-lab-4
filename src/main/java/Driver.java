public class Driver extends Personal {
    public Driver(int id, String name, float base) {
        super(id, name, base);
    }

    protected float calcSalaryDependOfTime() {
        return 10 * this.base;
    }

    protected float calcSalary() {
        this.payment = calcSalaryDependOfTime();
        return this.payment;
    }
}
