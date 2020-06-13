public class Programmer extends Engineer  {

    private int project;                                        // проект
    private int worktime;                                       // отработанное время
    private int base;                                           // ставка
    private int payment;                                        // заработная плата

    Programmer (int id, String name, String position, int base, int project, int worktime) {
        super(id, name, position);
        this.base = base;
        this.project = project;
        this.worktime = worktime;
    }

    public int calculateWorktimeSalary() {
            payment = worktime*base;
            return payment;
        }
        public int calculateProjectSalary() {
            payment = payment + (int) ((project*0.005));
            return payment;
        }

        public int calculateSalary() {
           int salary = calculateWorktimeSalary() + calculateProjectSalary();
           return salary;
    }
}

