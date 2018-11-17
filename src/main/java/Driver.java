class Driver extends Personal {
    Driver(long id, String name, long workTime, int base, int payment){
        super(id,name,workTime,base,payment);
    }

    public double calcPayment() {
        return payForHours();
    }

    public double payForHours() {
        if(getWorkTime()>150){return getWorkTime()*getBase()*1.5;}
        else return getWorkTime()*getBase();
    }

}