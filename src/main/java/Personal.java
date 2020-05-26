public class Personal extends Employee implements TimeWorking {
//fields
    protected double base;
//constructor
    public Personal(int id, String name, double base, int worktime){
        super(id, name);
        this.base = base;
        this.worktime = worktime;
    }
//methods
    public double getPaymentByWorkTime(){
        return this.worktime * this.base;
    }

    @Override
    public void calcPayment(){
        this.payment = this.getPaymentByWorkTime();
    }
}
