
    class Manager extends Employee implements Project{

         private int percentOfParticipate;
         private int sumOfProject;
         private String projectName;

           public Manager(long id, String name, long workTime, int base,
                   int payment, int percentOfParticipate, int sumOfProject, String projectName){
              super(id,name,workTime,base,payment);
              this.percentOfParticipate=percentOfParticipate;
              this.sumOfProject=sumOfProject;
              this.projectName=projectName;
            }




        public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getPercentOfParticipate() {
        return percentOfParticipate;
    }

    public void setPercentOfParticipate(int percentOfParticipate) {
        this.percentOfParticipate = percentOfParticipate;
    }

    public int getSumOfProject() {
        return sumOfProject;
    }

    public void setSumOfProject(int sumOfProject) {
        this.sumOfProject = sumOfProject;
    }

    public double payForProject() {
        return getPercentOfParticipate()*getSumOfProject()/100;
    }

    public double calcPayment() {
        return payForProject();
    }
}

    class ProjectManager extends Manager implements Heading{

          int subStuff;
          int payForOneSub;
          String project;

          public ProjectManager(long id, String name, long workTime,
                          int base, int payment, int percentOfParticipate,
                          int sumOfProject, int subStuff, int payForOneSub, String projectName){
               super(id,name,workTime,base,payment,percentOfParticipate,sumOfProject,projectName);
               this.subStuff=subStuff;
               this.payForOneSub=payForOneSub;
               this.project=projectName;
          }

    public int getSubStuff() {
        return subStuff;
    }

    public void setSubStuff(int subStuff) {
        this.subStuff = subStuff;
    }

    public int getPayForOneSub() {
        return payForOneSub;
    }

    public void setPayForOneSub(int payForOneSub) {
        this.payForOneSub = payForOneSub;
    }

    public double payForProject() {
        return getPercentOfParticipate()*getSumOfProject()/100;
    }
    public int payForHeading() {

        return getPayForOneSub()*getSubStuff();
    }
    public double calcPayment() {
        return payForProject()+payForHeading();
    }

    }

    class SeniorManager extends ProjectManager{

         public SeniorManager(long id, String name, long workTime,
                          int base, int payment, int percentOfParticipate,
                         int sumOfProject, int subStuff, int payForOneSub, String project){
        super(id,name,workTime,base,payment,percentOfParticipate,sumOfProject,subStuff,payForOneSub,project);

    }
    public double payForProject() {
        return getPercentOfParticipate()*getSumOfProject()/100;
    }
    public int payForHeading() {

        return getPayForOneSub()*getSubStuff();
    }
    public double calcPayment() {
        return payForProject()+payForHeading();
    }


}


