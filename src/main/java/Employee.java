
abstract class Employee{
    protected int ID;
    protected String name;
    protected int workTime;
    protected int payment;

    Employee(int id, String FIO){
        ID=id;
        name=FIO;
    }

    abstract public void setPayment();

    public int getPayment(){
        return payment;
    }
    public void setWorkTime(int time){
        workTime=time;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }
}

interface Project{
    final int budget = 1000000;
    public int getProjectPay();
}

interface WorkTime{
    public int PayCalc();
}


abstract class Personal extends Employee implements WorkTime {
    protected int rate;

    Personal(int id, String FIO, int Rate) {
        super(id, FIO);
        rate = Rate;
    }

    @Override
    public void setPayment() {
        payment = PayCalc();
    }
}

class Cleaner extends Personal{
    Cleaner(int id, String FIO, int Rate){
        super(id,FIO,Rate);
    }

    public int PayCalc() {
        return rate*workTime;
    }

}

class Driver extends Personal{
    Driver(int id, String FIO, int Rate){
        super(id,FIO,Rate);
    }

    public int PayCalc() {
        return rate*workTime+workTime*(rate/10);
    }

}


abstract class Engineer extends Employee implements Project,WorkTime {
    protected int rate;
    protected String projectName;
    protected int percentPay;
    Engineer(int id, String FIO, int Rate){
        super(id,FIO);
        rate=Rate;
    }

    public int getProjectPay() {
        if (getProjectName().equals("Messenger"))
            return (1000000/100)*percentPay;
        else if (getProjectName().equals("MusicPlayer"))
            return (500000/100)*percentPay;
        else if (getProjectName().equals("MobileBank"))
            return (2000000/100)*percentPay;
        else if (getProjectName().equals("All"))
            return (3500000/100)*percentPay;
        else return 0;
    }

    public int PayCalc(){
        return rate*workTime;
    }

    public String getProjectName(){
        return projectName;
    }

    @Override
    public void setPayment() {
        payment=getProjectPay()+PayCalc();
    }
}

class Tester extends Engineer{
    Tester(int id, String FIO, int Rate,String ProjectName){
        super(id,FIO,Rate);
        projectName=ProjectName;
        percentPay=1;
    }
}

class Programmer extends Engineer{
    Programmer(int id, String FIO, int Rate,String ProjectName){
        super(id,FIO,Rate);
        projectName=ProjectName;
        percentPay=2;
    }
}

interface Heading{
    final int headingPay=3000;
    public int getHeadingPay();
}

class TeamLeader extends Programmer implements Heading{
    protected int subordinate;

    TeamLeader(int id, String FIO, int Rate,String ProjectName, int Subordinate){
        super(id,FIO,Rate,ProjectName);
        subordinate=Subordinate;
    }

    public int getHeadingPay() {
        return headingPay*subordinate;
    }

    @Override
    public void setPayment() {
        payment=getHeadingPay()+getProjectPay()+PayCalc();
    }
}

class Manager extends Employee implements Project{
    protected int percentPay;
    protected String projectName;
    Manager(int id, String FIO, String ProjectName){
        super(id,FIO);
        projectName=ProjectName;
        percentPay=4;
    }

    public int getProjectPay() {
        if (getProjectName().equals("Messenger"))
            return (1000000/100)*percentPay;
        else if (getProjectName().equals("MusicPlayer"))
            return (500000/100)*percentPay;
        else if (getProjectName().equals("MobileBank"))
            return (2000000/100)*percentPay;
        else if (getProjectName().equals("All"))
            return (3500000/100)*percentPay;
        else return 0;
    }

    public String getProjectName(){
        return projectName;
    }

    @Override
    public void setPayment() {
        payment=10000+getProjectPay();
    }
}


class ProjectManager extends Manager implements Heading{
    protected int subordinate;
    ProjectManager(int id, String FIO, String ProjectName,int Subordinate){
        super(id,FIO,ProjectName);
        percentPay=10;
        subordinate=Subordinate;
    }

    public int getHeadingPay() {
        return headingPay*subordinate;
    }

    @Override
    public void setPayment() {
        payment=30000+getProjectPay()+getHeadingPay();
    }
}

class SeniorManager extends ProjectManager{
    SeniorManager(int id, String FIO, String ProjectName, int Subordinate){
        super(id,FIO,ProjectName,Subordinate);
        percentPay=20;
    }

    @Override
    public void setPayment() {
        payment=50000+getProjectPay()+getHeadingPay();
    }
}

