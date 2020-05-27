import java.util.HashSet;
import java.util.Set;

class Programmer extends Engineer {
    private static float irregular_k = 1.1f;
    public Programmer(int id, String name, int base) {
        super(id, name, base);
    }
    public Programmer(int id, String name, int base, HashSet<String> projects) {
        super(id, name, base, projects);
    }

    @Override
    public float moneyForWorktime() {
        return super.moneyForWorktime() * irregular_k;
    }
}

class Tester extends Engineer{
    public Tester(int id, String name, int base) {
        super(id, name, base);
    }
    public Tester(int id, String name, int base, HashSet<String> projects) {
        super(id, name, base, projects);
    }
}

class TeamLead extends Programmer implements Heading{
    protected HeadingJob headingJob;

    public TeamLead(int id, String name, int base) {
        super(id, name, base);
        headingJob = new HeadingJob();
    }
    public TeamLead(int id, String name, int base, HashSet<Integer> subordinateStaff, HashSet<String> projects){
        super(id, name, base, projects);
        headingJob = new HeadingJob(subordinateStaff);
    }
    @Override
    public Set<Integer> getSubordinateStaff() {
        return headingJob.getSubordinateStaff();
    }
    @Override
    protected float calculatePayment() {
        return super.calculatePayment() + moneyForHeading();
    }
    @Override
    public float moneyForHeading() {
        return headingJob.moneyForHeading(worktime);
    }
    @Override
    public boolean setSubordinateStaff(int id) {
        return headingJob.setSubordinateStaff(this, id);
    }
}
