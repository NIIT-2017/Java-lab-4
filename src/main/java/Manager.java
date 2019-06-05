abstract class Manager extends  Employee implements  Project{
    private int project;
    private int numofsubord;
    private  double part;

    public int proPyment(int total, double part) {
        int propyment = (int)(total*part);
        return propyment;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public int getNumofsubord() {
        return numofsubord;
    }

    public void setNumofsubord(int numofsubord) {
        this.numofsubord = numofsubord;
    }

    public double getPart() {
        return part;
    }

    public void setPart(double part) {
        this.part = part;
    }
}
