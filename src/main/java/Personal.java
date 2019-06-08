public abstract class Personal extends Employee implements WorkTime {
    protected int rate;

    public Personal(int id, String name, String position, int worktime, int rate) {
        super(id, name, position, worktime);
        this.rate = rate;
    }

    public int wtcalc() {
        return rate * worktime;
    }

}

class Cleaner extends Personal {

    public Cleaner(int id, String name, String position, int worktime, int rate) {
        super(id, name, position, worktime, rate);
    }

    @Override
    public int calc() {
        return payment = wtcalc();
    }
}

class Driver extends Personal {
    final protected int bonus = 3000;

    public Driver(int id, String name, String position, int worktime, int rate) {
        super(id, name, position, worktime, rate);
    }

    @Override
    public int calc() {
        if (worktime > 160) {
            return payment = wtcalc() + bonus;
        }
        return payment = wtcalc();
    }
}
