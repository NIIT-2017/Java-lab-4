class Programmer extends Engineer
{
    protected Programmer(int id, String name, String position, float base, String project, float share, int worktime)
    {
        super(id, name, position, base, project, share, worktime);
    }
    public static Programmer generate (int id, String name, String position, float base,
                                       String project, float share, int worktime) // is'h kakaya dlinnaya
    {
        return new Programmer(id,name,position,base,project,share,worktime);
    }
    public float CalcZP()
    {
        setPayment(calcProjectPay(project,share)+calcWorktime());
        return getPayment();
    }
}