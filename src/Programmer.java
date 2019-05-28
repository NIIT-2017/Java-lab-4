public class Programmer extends Engineer {
    public Programmer(int id, String name, int worktime, float payment,float projectShare){
        super(id, name, worktime, payment,projectShare);
    }

    public float calculateSalaryForWorkTime() {
        return (float)this.getWorktime()*this.getPayment();
    }

    public float calculateSalaryForProject() {
        return this.getProjectShare();
    }

    public float calculateSalary(){
        return this.calculateSalaryForWorkTime()+this.calculateSalaryForProject();
    }
}
