public class Manager extends Employee implements Project {
    String project;
    private double budget;
    private double portion;

    Manager(String id, String fio ,String project, double budget,double portion) {
        super(id, fio);
        this.project = project;
        this.budget = budget;
        this.portion= portion;
    }

    public double PrCalc() {
        return this.project.equals("") ? 0 : this.budget*this.portion ;
    }

    double Calc() {
        this.setPayment( this.PrCalc() );
        return this.getPayment();
    }
}
