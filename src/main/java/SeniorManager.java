class SeniorManager extends ProgectManager {

    private SeniorManager(int id, String name, String position, String progect, float share, int people) {
        super(id, name, position, progect, share, people);
    }

    public static SeniorManager generate(int id, String name, String position, String progect, float share, int people){
        return new SeniorManager(id,name,position,progect,share,people);
    }
}
