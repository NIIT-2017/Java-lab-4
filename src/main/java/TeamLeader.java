public class TeamLeader extends Programmer implements Heading {
    int number; // countable
    int one;

    public TeamLeader(int id, String name, int projectMoney, double part, int rate, int one) {
        super(id, name, projectMoney, part, rate);
        this.one = one;
    }


    public int headcalc(int number, int one) {
        return number * one;
    }

    public void calc() {
        payment = wtcalc(rate, worktime) + procalc(projectMoney, part) + headcalc(number, one);
    }
}
