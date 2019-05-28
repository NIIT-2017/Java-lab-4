import java.util.Map;

abstract class Manager extends Employee implements  Project {
    private float projectShare;


    public float getProjectShare() {
        return projectShare;
    }

    public void setProjectShare(float projectShare) {
        this.projectShare = projectShare;
    }


    public Manager(int id, String name, int worktime, float payment, float projectShare) {
        super(id, name, worktime, payment);
        this.projectShare = projectShare;
    }
}
