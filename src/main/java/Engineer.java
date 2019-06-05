abstract class Engineer extends Employee implements WorkTime, Project{
    private int project;
    private double part;


    public int wtPayment(int base, int hours) {
        int wtpayment = base*hours;
        return wtpayment;
    }

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

    public double getPart() {
        return part;
    }

    public void setPart(double part) {
        this.part = part;
    }
}
