class Manager extends Employee implements Progect{

    protected String progect;
    protected float share;

    protected Manager(int id, String name, String position, String progect, float share) {
        super(id, name, position);
        this.progect = progect;
        this.share = share;
    }

    public static Manager generate (int id, String name, String position,String progect,float share){
        return new Manager(id,name,position,progect,share);
    }

    @Override
    public float CalcSalary() {
        setPayment(calcProjectPay(progect,share));
        return getPayment();
    }

    @Override
    public float calcProjectPay(String progect, float share) {
        if (share >= 0){
            if (progect.equalsIgnoreCase("progect1")){
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
}
