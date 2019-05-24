public class ProjectManager extends Manager implements Heading {
    int countEmployee;

    public ProjectManager(int id, String name, float bonus, int countEmployee ) {
        super(id, name, bonus);
        this.countEmployee = countEmployee;
    }

    public float calcSalaryDependOfCountEmployee(int countEmployee) {
        return this.countEmployee * 1000 ;
    }

    public float calcSalaryDependOfShare() {
        return this.bonus * (float)0.5;
    }

    protected float calcSalary() {
        this.payment = calcSalaryDependOfCountEmployee(this.countEmployee)+calcSalaryDependOfShare();
        return this.payment;
    }
}
