abstract class Employee {
    protected int id;
    protected String name;
    protected int worktime; //отработанное время в днях
    protected int payment;


    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.worktime = 0;
        this.payment = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorktime() {
        return worktime;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    abstract void calc ();

}


interface WorkTime {
    int WorktimePay ();
}

interface Project {
    int project1 = 100000;
    int project2 = 200000;
    int project3 = 300000;

    int ProjectPay ();
}

interface Heading {
    int HeadingPay (int workers);
}



abstract class Personal extends Employee implements WorkTime {

    protected int base; //ставка за день
    Personal(int id, String name, int base) {
        super(id, name);
        this.base = base;
    }
}

class Cleaner extends Personal {
    public Cleaner (int id, String name, int base) {
        super (id, name, base);
    }

    public int WorktimePay () {
        return base*worktime;
    }

    public void calc () {
        setPayment(WorktimePay());
    }
}

class Driver extends Personal {
    Driver (int id, String name, int base){
        super (id, name, base);
    }

    public int WorktimePay () {
        return base*worktime+2000;
    }

    public void calc () {
        setPayment(WorktimePay());
    }

}

abstract class Engineer extends Employee implements WorkTime, Project {
    protected String ProjectName;
    protected double part; //процент от проекта
    protected int base;
    Engineer (int id, String name) {
        super (id, name);
        this.part = 0;
        this.ProjectName = "";
    }
}

class Programmer extends Engineer {
    Programmer (int id, String name, int b, String pname) {
        super (id, name);
        base = b;
        ProjectName = pname;
        part = 0.1;
    }

    public int WorktimePay () {
        return worktime*base;
    }

    public int ProjectPay () {
        switch(ProjectName) {
            case "Project1" : return (int) (project1*part);
            case "Project2" : return (int) (project2*part);
            case "Project3" : return (int) (project3*part);
            default : return 0;
        }
    }

    public void calc () {
        setPayment(WorktimePay()+ProjectPay());
    }
}

class Tester extends Engineer {
    Tester (int id, String name, int b, String pname){
        super (id, name);
        base = b;
        ProjectName = pname;
        part = 0.08;
    }

    public int WorktimePay () {
        return worktime*base;
    }

    public int ProjectPay () {
        switch(ProjectName) {
            case "Project1" : return (int) (project1*part);
            case "Project2" : return (int) (project2*part);
            case "Project3" : return (int) (project3*part);
            default : return 0;
        }
    }


    public void calc () {
        setPayment(ProjectPay()+WorktimePay());
    }

}

class TeamLeader extends Programmer implements Heading {
    protected int workers; //кол-во подчиненных
    TeamLeader (int id, String name, int b, String pname, int workers) {
        super (id, name, b, pname);
        part = 0.3;
        this.workers = workers;
    }

    public int HeadingPay (int workers) {
        return this.workers*5000;
    }

    @Override
    public void calc () {
        setPayment(HeadingPay(this.workers)+super.WorktimePay()+super.ProjectPay());
    }
}

class Manager extends Employee implements Project {
    protected String ProjectName;
    protected double part;
    Manager (int id, String name, String pname) {
        super (id, name);
        this.part = 0.4;
        this.ProjectName = pname;
    }

    public int ProjectPay () {
        switch(ProjectName) {
            case "Project1" : return (int) (project1*part);
            case "Project2" : return (int) (project2*part);
            case "Project3" : return (int) (project3*part);
            default : return 0;
        }
    }

    public void calc () {
        setPayment(ProjectPay());
    }

}

class ProjectManager extends Manager implements Heading {
    protected int workers;
    double part = 0.5;
    ProjectManager (int id, String name, String pname, int workers) {
        super (id, name, pname);
        this.workers = workers;
    }

    public int HeadingPay (int workers) {
        return workers*1000;
    }

    @Override
    public void calc () {
        setPayment(super.ProjectPay()+HeadingPay(this.workers));
    }
}

class SeniorManager extends ProjectManager {
    SeniorManager (int id, String name, String pname, int workers) {
        super (id, name, pname, workers);
    }

    @Override
    public int HeadingPay (int workers) {
        return workers*3000;
    }

    @Override
    public int ProjectPay (){
        return (int) ((project1+project2+project3)*this.part);
    }


}
