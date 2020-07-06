abstract class Engineer extends Employee implements WorkTime,Project
{
    protected float base;
    protected String project;
    protected float share;
    protected int worktime;
    public Engineer(int id, String name, String position, float base, String project, float share, int worktime)
    {
        super(id, name, position);
        this.base = base;
        this.project = project;
        this.share = share;
        this.worktime = worktime;
    }
    @Override
    public float calcProjectPay(String project, float share)
    {
        if (share>=0)
        {
            switch (project)
            {
                case "LEGO":
                    return share * 2000000;
                case "EA":
                    return share * 1500000;
                case "Allproject":
                    return share * 4500000;
                default:
                    return share * 1000000;
            }
        }
        else
            throw new RuntimeException("Проверь корректность ввода");
    }
    @Override
    public float calcWorktime()
    {
        return base * worktime;
    }
}