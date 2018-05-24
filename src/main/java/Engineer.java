abstract class Engineer extends Employee implements WorkTime,Project {

    private double paymentForHour;
    private double bonusPercentOfProject;
    private String project;


    Engineer(int id, String name, double worktime, double paymentForHour, double bonus,String project){
        super(id,name,worktime);
        this.paymentForHour=paymentForHour;
        this.bonusPercentOfProject=bonus/100;
        this.project=project;
    }

    public String getProject() {
        return project;
    }

    public double calcPaymentByProject() {
            return projectsCost[projects.valueOf(project).ordinal()] * bonusPercentOfProject;
    }

    public double calcPaymentByWorkTime() {
        return getWorktime()*paymentForHour;
    }

}
