public abstract class Employee {
    protected long id;
    protected String name;
    protected int workTime;
    protected double payment;

    Employee(long id, String name)
    {
        this.id=id;
        this.name=name;
    }

    public long getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getWorkTime(){
        return workTime;
    }

    public void setWorkTime(int workTime){
        this.workTime = workTime;
    }

    public double getPayment(){
        return payment;
    }

    public void setPayment(double payment){
        this.payment=payment;
    }

    abstract double calc();
    public abstract String toString();
}
