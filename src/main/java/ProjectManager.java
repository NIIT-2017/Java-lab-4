import java.util.ArrayList;

public class ProjectManager extends Manager implements Heading{
//fields
    protected ArrayList<Employee> subordinates;
//constructor
    public ProjectManager(int id, String name, double projectPart){
        super(id, name, projectPart);
        this.subordinates = new ArrayList<>();
    }
//getters
    public ArrayList<Employee> getSubordinates(){ return this.subordinates; }
//setters
    public void setSubordinates(ArrayList<Employee> subordinates){this.subordinates = subordinates; }
//methods
    public double getPaymentByHeading(){ return this.subordinates.size() * Heading.headingPremium; }

    @Override
    public void calcPayment(){
		this.payment = this.roundDouble(this.getPaymentByProject() + this.getPaymentByHeading(),2) ;
    }
}
