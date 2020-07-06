class Tester extends Engineer{

    private Tester(int id, String name, String position, float base, String progect, float share, int worktime) {
        super(id, name, position, base, progect, share, worktime);
    }

    public static Tester generate (int id, String name, String position, float base, String progect, float share, int worktime){
        return new Tester(id,name,position,base,progect,share,worktime);
    }

    public float CalcSalary() {
        setPayment(calcProjectPay(progect,share)+calcWorktime());
        return getPayment();
    }
}
