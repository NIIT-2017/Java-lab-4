public class ProjectManager extends Manager implements Heading{
     long subordinates;
    ProjectManager(String id, String fio, String project, double budget, double portion, long subordinates) {
        super(id, fio, project, budget, portion);
        this.subordinates = subordinates;
    }
    public double HeadCalc() {
        double subBase=20;
        return subBase*subordinates;
    }
    @Override
    public double Calc(){
        this.setPayment( super.Calc()+this.HeadCalc() );
        return this.getPayment();
    }


}
