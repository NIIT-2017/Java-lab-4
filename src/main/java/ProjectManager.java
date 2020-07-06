public class ProjectManager extends Manager implements Heading {
    private int subordinateCount;
    private double ratio;

    ProjectManager(int id, String name, String position, int project,
                   double part, int subordinateCount, double ratio){
        this.setId(id);
        this.setName(name);
        this.setPosition(position);
        this.setProject(project);
        this.setPart(part);
        this.subordinateCount = subordinateCount;
        this.ratio = ratio;
    }

    public int headCalc(int payment, int subordinateCount, double ratio){
        return (int)(subordinateCount  * payment * ratio);
    }

    public void setSubordinateCount(int subcount){
        this.subordinateCount = subcount;
    }

    public int getSubordinateCount(){
        return subordinateCount;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public double getRatio(){
        return ratio;
    }

    @Override
    public void calcSalary() {
        int p = prjPayment(this.getProject(), this.getPart());
        this.setPayment(p + headCalc(p, this.subordinateCount, this.ratio));
    }
}
