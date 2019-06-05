public class SeniorManager extends ProjectManager {
    SeniorManager(String id, String fio, String project, double budget, double portion, long subordinates) {
        super(id, fio, project, budget, portion, subordinates);
    }
    private final double base = 5000;

    @Override
    public double Calc(){
        this.setPayment(super.Calc()+this.base);
        return this.getPayment();
    }
}
