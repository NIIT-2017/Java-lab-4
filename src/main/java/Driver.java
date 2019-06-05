public class Driver  extends Personal {
    Driver(String id, String fio, double base){
        super(id, fio, base);
    }
    @Override
    public double  WtCalc() {
        final int bonus =200;
        final int timeInWeeek=40;
        setPayment(
            ( getWorktime() > timeInWeeek) ? (getBase()*getWorktime()+bonus) : (getBase()*getWorktime())
        );
        return getPayment();
    }
}