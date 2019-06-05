abstract public class Engineer extends Employee implements Project , Worktime {
    private String project;
    private double base;
    private double budget;
    private double portion;
    Engineer(String id, String fio, double base,String project, double budget, double portion){
        super(id, fio);
        this.base = base;
        this.project= project;
        this.budget = budget;
        this.portion = portion;
    }

    public double PrCalc() {
        return this.project.equals("") ? 0 : this.budget*this.portion ;

    }

    public double WtCalc() {
        return base*getWorktime();
    }

    public double Calc(){
        this.setPayment( this.PrCalc()+this.WtCalc() );
        return this.getPayment();
    }
}
