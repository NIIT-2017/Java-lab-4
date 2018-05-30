public abstract class Personal extends Employee implements WorkTime {
    protected double base;

    Personal(int id, String name, String position, double base) {
        super(id, name, position);
        this.base = base;
    }

    public void setBase(double base) {this.base = base;}
    public double getBase() {return base;}
}
