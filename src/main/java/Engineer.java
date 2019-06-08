public abstract class Engineer extends Employee implements WorkTime,Project {
    protected int rate;
    protected String project;
    protected int budget;
    protected double part;

    public Engineer(int id, String name, String position, int worktime, int rate, String project, int budget, double part) {
        super(id, name, position, worktime);
        this.rate = rate;
        this.project = project;
        this.budget = budget;
        this.part = part;
    }

    public int wtcalc() {
        return rate * worktime;
    }

    public int procalc() {
        return (int) (budget * part);
    }
}

class Programmer extends Engineer {

    public Programmer(int id, String name, String position, int worktime, int rate, String project, int budget, double part) {
        super(id, name, position, worktime, rate, project, budget, part);
    }

    @Override
    public int calc() {
        return payment = wtcalc() + procalc();
    }
}

class Tester extends Engineer {
    public Tester(int id, String name, String position, int worktime, int rate, String project, int budget, double part) {
        super(id, name, position, worktime, rate, project, budget, part);
    }

    @Override
    public int calc() {
        return payment = wtcalc() + procalc();
    }
}

class TeamLeader extends Programmer implements Heading {
    protected int subordinates;
    protected int sumForOne;

    public TeamLeader(int id, String name, String position, int worktime, int rate, String project, int budget, double part, int subordinates, int sumForOne) {
        super(id, name, position, worktime, rate, project, budget, part);
        this.subordinates = subordinates;
        this.sumForOne = sumForOne;
    }

    public int headcalc() {
        return subordinates * sumForOne;
    }

    @Override
    public int calc() {
        return payment = wtcalc() + procalc() + headcalc();
    }
}
