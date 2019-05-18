public abstract class Manager extends Employee implements Project {
    protected int projectMoney;
    protected double part;

    public Manager(int id, String fio, int projectMoney, double part) {
        super(id, fio);
        this.projectMoney = projectMoney;
        this.part = part;
    }

    public int procalc(int projectMoney, double part) {
        return (int) (projectMoney * part);
    }

    public int headcalc(int number, int one) {
        return number * one;
    }

}
