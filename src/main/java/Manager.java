abstract class Manager extends Employee implements Project{
    private int project;
    private double part;

    public int prjPayment(int project, double part) { return (int)(project*part); }

    public void setProject(int project){
        this.project = project;
    }
    public int getProject(){
        return project;
    }

    public void setPart(double part){
        this.part = part;
    }
    public double getPart(){
        return part;
    }
}
