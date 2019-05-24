public abstract class Engineer extends Employee implements WorkTime,Project {
    protected float base;
    protected float bonus;

    public Engineer(int id, String name,float base,float bonus) {
        super(id, name);
        this.base = base;
        this.bonus = bonus;
    }

    public float calcSalaryDependOfTime(float workTime, float base) {
        return workTime * base;
    }

    public float calcSalaryDependOfShare(float bonus) {
        return bonus;
    }
}
