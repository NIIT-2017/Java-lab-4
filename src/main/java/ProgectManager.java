class ProgectManager extends Manager implements Heading{

    final int basehead = 1000000;
    protected int people;

    protected ProgectManager(int id, String name, String position, String progect, float share, int people) {
        super(id, name, position, progect, share);
        this.people = people;
    }

    public static ProgectManager generate (int id, String name,String position, String progect, float share, int people){
        return new ProgectManager(id,name,position,progect,share,people);
    }

    @Override
    public float calcHeading() {
        return (float)0.05*basehead*people;
    }

    @Override
    public float CalcSalary() {
        setPayment(calcHeading()+calcProjectPay(progect,share));
        return getPayment();
    }
}
