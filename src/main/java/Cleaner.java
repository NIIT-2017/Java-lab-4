public class Cleaner extends Personal {

    public Cleaner(int id,String name,int rate){
        super(id,name,rate);
    }
    public void calc(){
        payment=wtcalc(rate,worktime);
    }
}
