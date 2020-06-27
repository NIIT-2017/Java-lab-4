class Cleaner extends Personal
{
    public Cleaner(int id, String name, int worktime, int base, String position)
    {
        super(id, name, worktime, base, position);
    }
    public static Cleaner generate(int id, String name, int worktime, int base,String position)
    {
        return new Cleaner(id,name,worktime,base,position);
    }
    @Override
    float CalcZP()
    {
        setPayment(calcWorktime());
        return getPayment();
    }
}