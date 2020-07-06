public abstract class Personal extends Employee
        implements WorkTime{

    protected double base; //for object implements WorkTime

    Personal(long id, String name, double base) {
        super(id, name);
        this.base=base;
    }

    public double getBase(){
        return base;
    }
    public void setBase(double base){
        this.base=base;
    }

    public double calcWork(int workTime){
        return 0.01*(double)workTime*base;
    }
}
