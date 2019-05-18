public class Driver extends Personal {
    public Driver(int id, String name, int rate) {
        super(id, name, rate);
    }

    public void calc() {
        payment = wtcalc(rate, worktime);
    }
}
