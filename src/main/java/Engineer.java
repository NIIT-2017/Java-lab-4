abstract class Engineer extends Employee implements Project, WorkTime {
    private int project = 0;
    private double part = 0;

    public int wtCalc(int time, int base) {
        return time*base;
    }
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
