public class Tester extends Engineer {
    public Tester(int id, String name, int worktime, float payment,float projectShare){
        super(id, name, worktime, payment,projectShare);
    }

    @Override
    public float calculateSalaryForWorkTime() {
        return (float)this.getWorktime()*this.getPayment();
    }

    @Override
    public float calculateSalaryForProject() {
        return this.getProjectShare();
    }

    public float calculateSalary(){
        return this.calculateSalaryForWorkTime()+this.calculateSalaryForProject();
    }
}
