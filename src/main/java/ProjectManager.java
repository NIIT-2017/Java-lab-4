class ProjectManager extends Manager implements Heading{

    int subStuff;
    int payForOneSub;
    String project;

    public ProjectManager(long id, String name, long workTime, int base, int payment, int percentOfParticipate,
                          int sumOfProject, int subStuff, int payForOneSub, String projectName){
        super(id,name,workTime,base,payment,percentOfParticipate,sumOfProject,projectName);
        this.subStuff=subStuff;
        this.payForOneSub=payForOneSub;
        this.project=projectName;
    }

    public int getSubStuff() {return subStuff;}
    public int getPayForOneSub() {return payForOneSub;}

    public void setSubStaff(int subStuff) {this.subStuff = subStuff;}
    public void setPayForOneSub(int payForOneSub) {this.payForOneSub = payForOneSub;}

    public double payForProject() {return getPercentOfParticipate()*getSumOfProject()/100;}
    public int payForHeading() {return getPayForOneSub()*getSubStuff();}
    public double calcPayment() {return payForProject()+payForHeading();}
}
