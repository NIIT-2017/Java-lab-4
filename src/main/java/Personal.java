public abstract class Personal extends Employee implements WorkTime {

    public double result(int worktime, double base){
        return worktime * base;
    }

    public abstract void calc();
}
