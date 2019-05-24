public abstract class Personal extends Employee implements WorkTime {
    protected float base;

    public Personal(int id, String name,float base) {
        super(id, name);
        this.base = base;
    }

    public float calcSalaryDependOfTime(float workTime, float base) {
        return workTime * base;
    }

}
