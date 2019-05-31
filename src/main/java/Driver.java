public class Driver extends Personal{
    protected boolean getBonus = false;
    final protected int bonus = 3000;
    public Driver(int id, String name, int rate){
        super(id, name, rate);
        if (rate > 180){
            getBonus = true;
        }
    }

    @Override
    public int calcPayment() {
        if (getBonus) {
            return super.calcPayment() + bonus;
        }
        else{
            return super.calcPayment();
        }
    }
}
