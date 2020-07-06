public class Manager extends Employee implements Projecting {
//fields
    protected Project project;
    protected double projectPart;
//constructor
    public Manager (int id, String name, double projectPart){
        super(id,name);
        this.projectPart = projectPart;
    }
//getters
    public Project getProject(){ return this.project; }
//setters
    public void setProject(Project project){ this.project = project; }
//methods
    public double getPaymentByProject() { return this.project.getProjectCost() * this.projectPart; }

    @Override
    public void calcPayment(){
        this.payment = this.roundDouble(this.getPaymentByProject(),2) ;
    }
}

