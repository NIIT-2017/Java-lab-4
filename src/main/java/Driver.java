public class Driver extends Personal{

    protected boolean premium = false;
    public Driver(int id, String name, int rate){

        super(id, name, rate);
        if (rate > 200){
            premium = true;
        }
    }

    @Override
    public int calcPayment() {
        if(premium) {
            return super.calcPayment();
        }
        else{
            return super.calcPayment();
        }
    }
}
