public class Cleaner extends Personal {
    public Cleaner(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.workload = employee.workload;
        this.rate = employee.rate;
    }
}
