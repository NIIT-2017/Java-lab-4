public class Driver extends Personal {
    public Driver(Employee employee){
        this.id = employee.id;
        this.name = employee.name;
        this.workload = employee.workload;
        this.rate = employee.rate;

    }
}
