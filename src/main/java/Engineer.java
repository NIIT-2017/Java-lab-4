public class Engineer extends Employee implements TimeWorking, Projecting {
//fields
    protected double base;
    protected Project project;
    protected double projectPart;
    protected String teamLeaderName;
//constructor
    public Engineer (int id, String name, double base, int worktime, double projectPart){
        super(id, name);
        this.worktime = worktime;
        this.base = base;
        this.projectPart = projectPart;
    }
//getters
    public double getBase(){ return this.base; }
    public Project getProject (){ return this.project; }
    public String getTeamLeaderName(){ return this.teamLeaderName; }
//setters
    public void setProject(Project project){ this.project = project; }
    public void setTeamLeaderName(String teamLeaderName){ this.teamLeaderName = teamLeaderName; }
//methods
    public double getPaymentByWorkTime(){
        return this.worktime * this.base;
    }

    public double getPaymentByProject() { return this.project.getProjectCost() * this.projectPart; }

    @Override
    public void calcPayment(){
        this.payment = this.getPaymentByWorkTime() + this.getPaymentByProject();
    }
}
