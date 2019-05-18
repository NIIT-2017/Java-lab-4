public class Programmer extends Engineer {
    public Programmer(int id, String name, int projectMoney, double part, int rate) {
        super(id, name, projectMoney, part, rate);
    }

    void calc() {
        payment = procalc(projectMoney, part) + wtcalc(rate, worktime);
    }

}
