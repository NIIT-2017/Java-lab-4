abstract class Personal extends Employee implements WorkTime
{
    protected int base;
    protected int worktime;
    public Personal(int id, String name, int worktime, int base, String position)
    {
        super(id, name,position);
        this.base = base;
        this.worktime = worktime;
    }
    public float calcWorktime()
    {
        if (base >=0 && worktime >=0)
            return base*worktime;
        else
            throw new RuntimeException("Проверь корректность ввода");
    }
}