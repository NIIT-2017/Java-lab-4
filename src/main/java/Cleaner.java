public class Cleaner extends Personal {
    Cleaner(String id, String fio, double base){
        super(id, fio, base);
    }

    @Override
    public double WtCalc() {
        return super.WtCalc();
    }
/*  второй вариант делать абстрактным класс Personal
    тогда тут нужен этот метод
    public double  WtCalc() {
        setPayment( getBase()*getWorktime() );
        return getPayment();
    }
 */
}
