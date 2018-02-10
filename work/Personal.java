public abstract class Personal extends Employee implements WorkTime{
    protected int base;

    Personal(int id, String name, String position, int base){
        super(id, name, position);
        this.base = base;
    }

}

class Cleaner extends Personal{
    Cleaner (int id, String name, String position, int base){
        super(id,name,position,base);
    }

    public int workTime(int time, int base){
        int payment = time * base;
        return payment;
    }
    public void totalPayment(){
        this.payment += this.workTime(this.time,this.base);
    }
}

class Driver extends Personal{
    Driver (int id, String name, String position, int base) {
        super(id, name, position, base);
    }

    public int workTime(int time, int base){
        int payment = time * base + ((time*10/100)*base*20/100);
        return payment;
    }
    @Override
    public void totalPayment(){
        this.payment += this.workTime(this.time,this.base);

    }

}
