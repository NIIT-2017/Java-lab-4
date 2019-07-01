public class Programmer extends Engineer {
    public Programmer(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.workload = employee.workload;
        this.rate = employee.rate;
        this.project = employee.project;
    }

}
