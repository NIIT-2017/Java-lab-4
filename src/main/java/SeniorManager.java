class SeniorManager extends ProjectManager {
    SeniorManager(int id, String name, double worktime, double bonus,int amountEmploy,String project){
        super(id,name,worktime,bonus,amountEmploy,project);
    }

    @Override
    double CalcPayment() {
        return super.CalcPayment();
    }
}
