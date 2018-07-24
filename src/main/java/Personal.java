abstract public class Personal extends Employee implements WorkTime {
    Personal() {
        super();
    }

    Personal(int id, String name, int worktime, int payment) {
        super(id, name, worktime, payment);
    }


}
