
public class Cleaner extends Personal {
    public Cleaner(int id, String name, int worktime, double base){
        this.id = id;
        this.name = name;
        this.worktime = worktime;
        this.base = base;
    }

    public void calc() {
        this.payment = result(worktime, base);
    }
}
