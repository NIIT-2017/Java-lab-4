class Manager extends Employee implements Project
{
    protected String project;
    protected float share;
    protected Manager(int id, String name, String position, String project, float share)
    {
        super(id, name, position);
        this.project = project;
        this.share = share;
    }
    public static Manager generate (int id, String name, String position,String project,float share)
    {
        return new Manager(id,name,position,project,share);
    }
    @Override
    public float CalcZP()
    {
        setPayment(calcProjectPay(project,share));
        return getPayment();
    }
    @Override
    public float calcProjectPay(String project, float share)
    {
        if (share >= 0)
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
}