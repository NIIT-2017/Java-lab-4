public class TeamLeader extends Programmer implements Heading {
    private int subordinateCount;
    private double ratio;

    TeamLeader(int id, String name, String position, int base, int project,
               double part, int subordinateCount, double ratio){
        super(id, name, position, base, project, part);
        this.subordinateCount = subordinateCount;
        this.ratio = ratio;
    }

    public void setSubordinateCount(int subcount){
        this.subordinateCount = subcount;
    }

    public int getSubordinateCount(){
        return subordinateCount;
    }

    public void setRatio(double ratio){
        this.ratio = ratio;
    }

    public double getRatio(){
        return ratio;
    }

    public int headCalc(int payment, int subordinateCount, double ratio){
        return (int)(subordinateCount  * payment * ratio);
    }

    @Override
    public void calcSalary() {
        int p = wtCalc(this.getWorktime(), this.getBase()) + prjPayment(this.getProject(), this.getPart());
        this.setPayment(p + headCalc(p, this.subordinateCount, this.ratio));
    }
}
