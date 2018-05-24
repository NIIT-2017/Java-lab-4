class Manager extends Employee implements Project {
    private double bonusPercentOfProject;
    private String project;

    Manager(int id, String name, double worktime, double bonus,String project){
        super(id,name,worktime);
        bonusPercentOfProject=bonus/100;
        this.project=project;
    }

    public double calcPaymentByProject() {
        return projectsCost[projects.valueOf(project).ordinal()]*bonusPercentOfProject;
    }

    @Override
    double CalcPayment() {
        double pay=calcPaymentByProject();
        setPayment(pay);
        return pay;
    }
}
