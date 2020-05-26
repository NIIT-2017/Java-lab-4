import java.util.ArrayList;

public class TeamLeader extends Programmer implements Heading{
//field
    private ArrayList<Employee> teammates;
//constructor
    public TeamLeader(int id, String name, double base, int worktime, double projectPart){
        super(id,name,base,worktime,projectPart);
        this.teammates = new ArrayList<>();
    }
//getters
    public ArrayList<Employee> getTeammates(){ return this.teammates; }
//methods
    public double getPaymentByHeading(){ return this.teammates.size() * Heading.headingPremium; }

    @Override
    public void calcPayment(){
        this.payment = this.getPaymentByWorkTime() + this.getPaymentByProject() + this.getPaymentByHeading();
    }
}
