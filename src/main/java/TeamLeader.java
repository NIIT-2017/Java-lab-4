import java.util.HashMap;

public class TeamLeader extends Engineer
        implements Heading{
    private int personal;

    TeamLeader(long id, String name, double base, HashMap<String, Double> mapProjectsPercent, int personal) {
        super(id, name,base,mapProjectsPercent);
        this.personal=personal;
    }

    public int getPersonal(){
        return personal;
    }

    public void setPersonal(int personal){
        this.personal=personal;
    }

    public double calcHeading(int personal) {
        return (paymentPersonal*personal)*workTime/160;
    }

    double calc() {
        payment=calcWork(getWorkTime())+calcProject(mapProjectsPercent)+calcHeading(personal);
        return payment;
    }

    @Override
    public String toString(){
        return "TeamLeader";
    }
}
