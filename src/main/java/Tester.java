public class Tester extends Engineer {
    Tester(int id, String name, String position, double base, double share, String project) {
        super(id, name, position, base, share, project);
    }

    public double calcPaymentFromTime() {
        return base * time;
    }

    public double calcPaymentFromProject() {
        return share * DataLoader.getProjectBudgets(project);
    }

    public void calcPayment() {
        payment = this.calcPaymentFromTime() + this.calcPaymentFromProject();
    }
}
