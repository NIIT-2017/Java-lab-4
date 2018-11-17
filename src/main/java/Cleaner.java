class Cleaner extends Personal {
    Cleaner(long id, String name, long workTime, int base,int payment){
        super(id,name,workTime,base,payment);
    }

    public double calcPayment() {return payForHours();}

    public double payForHours() {
        if(getWorkTime()>100) {return getWorkTime() * getBase() * 1.3;}
        else return getWorkTime()*getBase();
    }
}