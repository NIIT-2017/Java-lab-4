abstract class Engineer extends Employee implements WorkTime,Progect{

    protected float base;
    protected String progect;
    protected float share;
    protected int worktime;

    public Engineer(int id, String name, String position, float base, String progect, float share, int worktime) {
        super(id, name, position);
        this.base = base;
        this.progect = progect;
        this.share = share;
        this.worktime = worktime;
    }

    @Override
    public float calcProjectPay(String progect, float share) {
        if (share>=0){
            if (progect.equals("progect1")){
                return share*2000000;
            }
            else if (progect.equals("progect2")){
                return share*1500000;
            }
            else if (progect.equals("Allprogect")){
                return share*4500000;
            }
            else {
                return share*1000000;
            }
        }
        else
            throw new RuntimeException("Неверные значения полей");
    }

    @Override
    public float calcWorktime() {
        return base*worktime;
    }
}
