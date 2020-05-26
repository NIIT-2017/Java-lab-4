public class Employee {
//fields
    protected int id;
    protected String name;
    protected int worktime;
    protected double payment;
    protected POSITIONS position;
//constructor
    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
//getters
    public int getID(){ return this.id; }
    public String getName(){ return this.name; }
    public int getWorktime(){ return this.worktime; }
    public double getPayment(){ return this.payment; }
    public POSITIONS getPosition(){ return this.position; }
//setters
    public void setPosition(POSITIONS position){
    this.position = position;
}
//methods
    public void calcPayment(){}
}
