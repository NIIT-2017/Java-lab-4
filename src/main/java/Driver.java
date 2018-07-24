public class Driver extends  Personal {
    Driver() {
        super();
    }

    Driver(int id, String name, int worktime, int payment) {
        super(id, name, worktime, payment);
    }


    public int calcPay() {
        return payment*worktime;
    }
}
