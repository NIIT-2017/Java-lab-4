package Staff;

abstract class Employee {

    //fields
    protected int id;
    protected String fio;
    protected int workTime;
    protected double payment;
    protected int baseRate;
    protected DeveloperCompany company;
    protected String position;
    //---------------------------------------------------------

    //constructor
    public Employee(int id, String fio, DeveloperCompany company) {
        this.id = id;
        this.fio = fio;
        this.company = company;
    }
    //---------------------------------------------------------

    //methods
    abstract double salaryCalculator();
    @Override
    public String toString() {
        return id+" - "+workTime+" - "+position+" - "+fio+" - "+payment;
    }
    //---------------------------------------------------------

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }
    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
    public void setPayment() {
        int buf = (int)(salaryCalculator()*10);
        this.payment = (double)buf/10;
    }
    //---------------------------------------------------------

    //getters
    public int getId() {
        return id;
    }
    public String getFio() {
        return fio;
    }
    public int getWorkTime() {
        return workTime;
    }
    public double getPayment() {
        return payment;
    }
    public String getPosition(){return position;}
    //---------------------------------------------------------
}

abstract class Personal extends Employee implements WorkTime{

    //constructor
    public Personal(int id, String fio, int workTime, DeveloperCompany company) {
        super(id, fio, company);
        this.workTime = workTime;
        baseRate = company.getBaseRate();
    }
    //---------------------------------------------------------

    //methods
    public double hourlyPay() {
        return baseRate*workTime;
    }
    public double salaryCalculator() {
        return hourlyPay();
    }
    //---------------------------------------------------------

    //setters
    public void setBaseRate(int baseRate) {
        this.baseRate = baseRate;
    }
    //---------------------------------------------------------

    //getters
    public int getBaseRate() {
        return baseRate;
    }
    //---------------------------------------------------------
}

abstract class Engineer extends Employee implements Project, WorkTime{

    //fields
    protected DevelopProjects project;
    //---------------------------------------------------------

    //constructor
    public Engineer(int id, String fio, int workTime, DeveloperCompany company) {
        super(id, fio, company);
        this.workTime = workTime;
        baseRate = company.getBaseRate();
    }
    //---------------------------------------------------------

    //methods
    public double salaryCalculator() {
        return hourlyPay()+projectPayment();
    }

    public double hourlyPay() {
        double skillRating= 1.8;
        return baseRate*skillRating*workTime;
    }

    public double projectPayment() {
        if (project!=null && project.isItPossibleToPay())
            return (project.getBudget()*0.35)/(project.getEngineers().size());
        else
            return 0;
    }
    //---------------------------------------------------------

    //setters
    public void setProject(DevelopProjects project) {
        this.project = project;
    }
    //---------------------------------------------------------

    //getters
    public DevelopProjects getProject() {
        return project;
    }
    //---------------------------------------------------------
}

interface WorkTime{
    double hourlyPay();
}

interface Project{
    double projectPayment();
}

interface Heading{
    double managementFee(DevelopProjects project);
}