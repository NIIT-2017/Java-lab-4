public abstract class Engineer extends Employee implements WorkTime, Project {

    Engineer(int id, String name, String position) {
        super(id, name, position);
    }

    public int calculateProjectSalary() {
        int payment = 0;
        return payment;
    }
    public int calculateWorktimeSalary() {
        int salary = calculateProjectSalary();
        return salary;
    }
}
