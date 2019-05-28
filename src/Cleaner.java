public class Cleaner extends Personal{
    public Cleaner(int id, String name, int worktime, float payment){
        super(id, name, worktime, payment);
    }

    @Override
    public float calculateSalaryForWorkTime(){
      return (float)this.getWorktime()*this.getPayment();
    }

    public float calculateSalary(){
        return this.calculateSalaryForWorkTime();
    }
}
