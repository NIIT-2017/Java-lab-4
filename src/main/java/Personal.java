abstract class Personal extends Employee implements WorkTime {

    protected int base; //ставка за день

    Personal(int id, String name, int base) {
        super(id, name);
        this.base = base;
    }
}