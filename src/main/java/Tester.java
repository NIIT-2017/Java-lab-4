public class Tester extends Engineer {
    public Tester(int id, String name, int projectMoney, double part, int rate) {
        super(id, name, projectMoney, part, rate);
    }

    public void calc() {
        payment = wtcalc(rate, worktime) + procalc(projectMoney, part);
    }
}
