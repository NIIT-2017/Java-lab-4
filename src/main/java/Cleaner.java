public class Cleaner extends Personal {

    private int worktime;                                       // отработанное время
    private int base;                                           // ставка
    private int payment;                                        // заработная плата

    Cleaner (int id, String name, String position, int base, int worktime) {
        super(id, name, position);
        this.base = base;
        this.worktime = worktime;
    }

    public int calculateWorktimeSalary() {
        int payment = worktime*base;
        return payment;
    }

    public int calculateSalary() {
        int salary = calculateWorktimeSalary();
        return salary;
    }
}

