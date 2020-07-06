class SeniorManager extends ProjectManager
{
    private SeniorManager(int id, String name, String position, String project, float share, int people)
    {
        super(id, name, position, project, share, people);
    }
    public static SeniorManager generate(int id, String name, String position, String project, float share, int people)
    {
        return new SeniorManager(id,name,position,project,share,people);
    }
}