public class TeamLeader extends Employee implements Heading {

    private int payment;                                        // заработная плата
    private int base;                                           // ставка

    TeamLeader(int id, String name, String position, int base) {
        super(id, name, position);
        this.base = base;
    }

    public int calculateHeadingSalary() {
        payment =  base*Controller.controller.getNumberEngineer();
        return payment;
    }

    public int calculateSalary(){
        int salary = calculateHeadingSalary();
        return salary;
    }
}
