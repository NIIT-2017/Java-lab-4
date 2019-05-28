abstract class Engineer extends Employee implements WorkTime,Project {
    private float projectShare;

    public float getProjectShare() {
        return projectShare;
    }

    public void setProjectShare(float projectShare) {
        this.projectShare = projectShare;
    }


    public Engineer(int id, String name, int worktime, float payment, float projectShare) {
        super(id, name, worktime, payment);
        this.projectShare=projectShare;
    }
}
