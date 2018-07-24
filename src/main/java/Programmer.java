public class Programmer extends Engineer {
    static int countProg = 0;

    Programmer(){
        super();
    }
    Programmer(int id, String name, int worktime, int payment){
        super(id, name, worktime, payment);
        countProg++;
    }

    public int calcPayAtProj() {
        return (int) (0.07*cash);
    }

    public int calcPay() {
        return payment*worktime+calcPayAtProj();
    }
}
