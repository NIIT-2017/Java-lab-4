public class SeniorManager extends ProjectManager {
    public SeniorManager(int id, String name, float bonus, int countEmployee) {
        super(id, name, bonus, countEmployee);
    }

    @Override
    public float calcSalaryDependOfShare() {
        return super.calcSalaryDependOfShare();
    }

    @Override
    protected float calcSalary() {
        return super.calcSalary();
    }

}
