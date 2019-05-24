public abstract class Manager extends Employee implements Project {
    float bonus;

    public Manager(int id, String name,float bonus) {
        super(id, name);
        this.bonus = bonus;
    }
}
