public class Cleaner extends Personal {

    public Cleaner(int id, String name, float base) {
        super(id, name, base);
    }

    protected float calcSalaryDependOfTime() {
        return 15 * this.base;
    }

    protected float calcSalary() {
        this.payment = calcSalaryDependOfTime();
        return this.payment;
    }

}
