public abstract class Personal extends Employee implements WorkTime{
    protected int rate;

    public Personal(int id, String name, int rate){
        super(id, name);
        this.rate = rate;
    }
    public int calcPaymentByRate(){
        return worktime * rate;
    }

    @Override
    public int calcPayment(){
        return calcPaymentByRate();
    }
}
