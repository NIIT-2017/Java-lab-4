public class Tester extends Engineer {
    Tester(){
        super();
    }
    Tester(int id, String name, int worktime, int payment){
        super(id, name, worktime, payment);
    }

    public int calcPayAtProj() {
        return (int) (0.05*cash);
    }

    public int calcPay() {
        return payment*worktime+calcPayAtProj();
    }
}
