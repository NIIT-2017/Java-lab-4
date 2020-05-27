import java.util.HashSet;
import java.util.Set;

class Manager extends Employee implements Project {
    protected ProjectJob projectJob;

    public Manager(int id, String name) {
        super(id, name);
        projectJob = new ProjectJob();
    }
    public Manager(int id, String name, HashSet<String> projects) {
        super(id, name);
        projectJob = new ProjectJob(projects);
    }

    @Override
    public Set<String> getProjects() {
        return projectJob.getProjects();
    }
    @Override
    protected float calculatePayment() {
        return moneyForProjects();
    }
    @Override
    public float moneyForProjects() {
        return projectJob.moneyForProjects(id);
    }
    @Override
    public boolean setProject(String projectTitle) {
        return projectJob.setProject(id, projectTitle);
    }
}

class ProjectManager extends Manager implements Heading{
    protected HeadingJob headingJob;

    public ProjectManager(int id, String name) {
        super(id, name);
        headingJob = new HeadingJob();
    }
    public ProjectManager(int id, String name, HashSet<Integer> subordinateStaff, HashSet<String> projects) {
        super(id, name, projects);
        headingJob = new HeadingJob(subordinateStaff);
    }
    @Override
    public Set<Integer> getSubordinateStaff() {
        return headingJob.getSubordinateStaff();
    }
    @Override
    protected float calculatePayment() {
        return moneyForProjects() + moneyForHeading();
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

class SeniorManager extends ProjectManager{
    private static float quarterBonus = 5000;
    public SeniorManager(int id, String name) {
        super(id, name);
    }
    public SeniorManager(int id, String name, HashSet<Integer> subordinateStaff, HashSet<String> projects) {
        super(id, name, subordinateStaff, projects);
    }
    @Override
    protected float calculatePayment() {
        return super.calculatePayment() + (quarterBonus * worktime / 200);
    }
}
