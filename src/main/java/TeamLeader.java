public class TeamLeader extends Programmer implements Heading {
    TeamLeader(){
        super();
    }

    TeamLeader(int id, String name, int worktime, int payment){
        super(id, name, worktime, payment);
        countProg--;
    }

    public int calcPayAtProg() {
        return Programmer.countProg*1000;
    }

    @Override
    public int calcPay() {
        return super.calcPay() + calcPayAtProg();
    }

}
