class SeniorManager extends ProjectManager {
    SeniorManager(int id, String name, double workTime, double bonus,int amountEmployees,String project) {
        super(id, name, workTime, bonus,amountEmployees, project);
    }

    @Override
    double calcPayment(){
        return super.calcPayment();
    }
}