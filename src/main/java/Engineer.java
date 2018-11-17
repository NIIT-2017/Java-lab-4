abstract class Engineer extends Employee implements WorkTime, Project{

    public static int sumOfProject;
    public static int percentOfParticipate;
    String projectName;

    public Engineer(long id, String name, long workTime, int base,int payment,int sumOfProject, int percentOfParticipate,
                    String projectName ) {
        super(id,name,workTime,base,payment);
        this.sumOfProject=sumOfProject;
        this.percentOfParticipate=percentOfParticipate;
        this.projectName=projectName;
    }

    public String getProjectName() {return projectName;}
    public int getSumOfProject() {return sumOfProject;}
    public int getPercentOfParticipate() {return percentOfParticipate;}

    public void setProjectName(String projectName) {this.projectName = projectName;}
    public void setSumOfProject(int sumOfProject) {this.sumOfProject = sumOfProject;}
    public void setPercentOfParticipate(int percentOfParticipate) {this.percentOfParticipate = percentOfParticipate;}

    public abstract double payForProject();
    public abstract double payForHours();
}

