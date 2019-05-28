public class Driver extends Personal{
    public Driver(int id, String name, int worktime, float payment){
        super(id, name, worktime, payment);
    }

    public float calculateSalaryForWorkTime(){
        return (float)this.getWorktime()*this.getPayment();
    }

    public float calculateSalary(){
        return this.calculateSalaryForWorkTime();
    }
}