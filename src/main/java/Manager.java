public abstract class Manager extends Employee implements Project {
    protected String project;
    protected int budget;
    protected double part;

    public Manager(int id, String name, String position, int worktime, String project, int budget, double part) {
        super(id, name, position, worktime);
        this.project = project;
        this.budget = budget;
        this.part = part;
    }

    public int procalc() {
        return (int) (budget * part);
    }

}

class ProjectManager extends Manager implements Heading {
    protected int subordinates;
    protected int sumForOne;

    public ProjectManager(int id, String name, String position, int worktime, String project, int budget, double part, int subordinates, int sumForOne) {
        super(id, name, position, worktime, project, budget, part);
        this.subordinates = subordinates;
        this.sumForOne = sumForOne;
    }

    public int headcalc() {
        return subordinates * sumForOne;
    }

    @Override
    public int calc() {
        return payment = procalc() + headcalc();
    }
}

class SeniorManager extends ProjectManager {
    public SeniorManager(int id, String name, String position, int worktime, String project, int budget, double part, int subordinates, int sumForOne) {
        super(id, name, position, worktime, project, budget, part, subordinates, sumForOne);
    }
}
