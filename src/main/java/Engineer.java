public abstract class Engineer extends Employee implements Worktime, Project {
    protected int rate;
    protected int projectMoney;
    protected double part;

    public Engineer(int id, String name, int projectMoney, double part, int rate) {
        super(id, name);
        this.projectMoney = projectMoney;
        this.part = part;
        this.rate = rate;
    }

    public int procalc(int projectMoney, double part) {
        return (int) (projectMoney * part);
    }

    public int wtcalc(int rate, int worktime) {
        return (int) (rate * worktime + 10000);
    }
}
