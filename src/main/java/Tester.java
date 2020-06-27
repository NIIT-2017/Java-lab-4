class Tester extends Engineer
{
    private Tester(int id, String name, String position, float base, String project, float share, int worktime)
    {
        super(id, name, position, base, project, share, worktime);
    }
    public static Tester generate (int id, String name, String position, float base, String project, float share, int worktime)
    {
        return new Tester(id, name, position, base, project, share, worktime);
    }
    public float CalcZP()
    {
        setPayment(calcProjectPay(project, share) + calcWorktime());
        return getPayment();
    }
}