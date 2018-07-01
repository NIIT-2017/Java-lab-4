class ProjectManager extends  Manager implements Heading{
    private int amountOfEmployees;
    ProjectManager(int id, String name, double workTime, double bonus,int amountEmployees,String project) {
        super(id, name, workTime, bonus, project);
        this.amountOfEmployees = amountEmployees;
    }

    public double calcPaymentByHeading(){
        return amountOfEmployees * payForEmployee;
    }

    @Override
    double calcPayment(){
        return super.calcPayment() + calcPaymentByHeading();
    }
}
