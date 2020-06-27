class Driver extends Personal
{
    public Driver(int id, String name, int worktime, int base, String position)
    {
        super(id, name, worktime, base, position);
    }
    public static Driver generate(int id, String name, int worktime, int base, String position)
    {
        return new Driver(id,name,worktime,base, position);
    }
    public float CalcZP()
    {
        setPayment(calcWorktime());
        return getPayment();
    }
}