class TeamLeader extends Programmer implements Heading
{
    private int people;
    final int basehead = 1000000;
    private TeamLeader(int id, String name, String position, float base,
                       String project, float share, int worktime, int people)
    {
        super(id, name, position, base, project, share, worktime);
        this.people = people;
    }
    public static TeamLeader generate(int id, String name, String position, float base,
                                      String project, float share, int worktime, int people)
    {
        return new TeamLeader(id, name, position, base, project, share, worktime, people);
    }
    @Override
    public float calcHeading()
    {
        return (float)0.05 * basehead * people;
    }
    @Override
    public float CalcZP()
    {
        setPayment(super.CalcZP() + calcHeading());
        return getPayment();
    }
}