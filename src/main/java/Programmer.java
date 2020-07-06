class Programmer extends Engineer{

    protected Programmer(int id, String name, String position, float base, String progect, float share, int worktime) {
        super(id, name, position, base, progect, share, worktime);
    }

    public static Programmer generate (int id, String name, String position, float base, String progect, float share, int worktime){
        return new Programmer(id,name,position,base,progect,share,worktime);
    }

    public float CalcSalary() {
        setPayment(calcProjectPay(progect,share)+calcWorktime());
        return getPayment();
    }
}
