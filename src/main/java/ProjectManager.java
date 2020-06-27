class ProjectManager extends Manager implements Heading
{
    final int basehead = 1000000;
    protected int people;
    protected ProjectManager(int id, String name, String position, String project, float share, int people)
    {
        super(id, name, position, project, share);
        this.people = people;
    }
    public static ProjectManager generate (int id, String name,String position, String project, float share, int people)
    {
        return new ProjectManager(id,name,position,project,share,people);
    }
    @Override
    public float calcHeading()
    {
        return (float)0.05 * basehead * people;
    }
    @Override
    public float CalcZP()
    {
        setPayment(calcHeading()+calcProjectPay(project,share));
        return getPayment();
    }
}