public class ProjectManager extends Manager implements Heading{
    protected int number; //countable
    protected int one;
    public ProjectManager(int id, String name, int projectMoney, double part,int one){
        super(id,name,projectMoney,part);
        this.one=one;
    }
    void calc(){
        payment=headcalc(number,one)+procalc(projectMoney,part);
    }
}
