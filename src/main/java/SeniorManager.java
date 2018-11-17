class SeniorManager extends ProjectManager{

    public SeniorManager(long id, String name, long workTime, int base, int payment, int percentOfParticipate,
                         int sumOfProject, int subStuff, int payForOneSub, String project){
        super(id,name,workTime,base,payment,percentOfParticipate,sumOfProject,subStuff,payForOneSub,project);
    }

    public double payForProject() {return getPercentOfParticipate() * getSumOfProject() / 100;}
    public int payForHeading() {return getPayForOneSub() * getSubStuff();}
    public double calcPayment() {return payForProject() + payForHeading();}
}
