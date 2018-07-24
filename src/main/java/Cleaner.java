public class Cleaner extends Personal {
    Cleaner() {
        super();
    }

    Cleaner(int id, String name, int worktime, int payment) {
        super(id, name, worktime, payment);
    }



    public int calcPay() {
        return payment*worktime;
    }
}
