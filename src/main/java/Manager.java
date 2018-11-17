class Manager extends Employee implements Project{

    private int percentOfParticipate;
    private int sumOfProject;
    private String projectName;

    public Manager(long id, String name, long workTime, int base, int payment, int percentOfParticipate,
                   int sumOfProject, String projectName){
        super(id,name,workTime,base,payment);
        this.percentOfParticipate=percentOfParticipate;
        this.sumOfProject=sumOfProject;
        this.projectName=projectName;
    }

    public String getProjectName() {return projectName;}
    public int getPercentOfParticipate() {return percentOfParticipate;}
    public int getSumOfProject() {return sumOfProject;}

    public void setProjectName(String projectName) {this.projectName = projectName;}
    public void setPercentOfParticipate(int percentOfParticipate) {this.percentOfParticipate = percentOfParticipate;}
    public void setSumOfProject(int sumOfProject) {this.sumOfProject = sumOfProject;}

    public double payForProject() {return getPercentOfParticipate()*getSumOfProject()/100;}
    public double calcPayment() {return payForProject();}
}