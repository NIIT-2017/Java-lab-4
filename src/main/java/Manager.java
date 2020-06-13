public abstract class Manager extends Employee implements Project {

    Manager (int id, String name, String position) {
        super(id, name, position);
    }

    public int calculateProjectSalary() {
        int  salary = 0;
        return salary;
    }
}
