class ProjectManager extends Manager implements Heading {
    private int amountOfEmploy;
    ProjectManager(int id, String name, double worktime, double bonus,int amountEmploy,String project){
        super(id,name,worktime,bonus,project);
        this.amountOfEmploy=amountEmploy;
    }


    public double calcPaymentByHeading() {
        return amountOfEmploy*payForEmploy;
    }

    @Override
    double CalcPayment() {
        return super.CalcPayment()+calcPaymentByHeading();
    }
}
