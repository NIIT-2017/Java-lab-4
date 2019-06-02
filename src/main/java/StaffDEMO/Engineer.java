package StaffDEMO;

public
abstract class Engineer extends Employee implements WorkTime, Project{

    protected String project;
    protected double projectMoney;
    protected double part;

    public
    Engineer ( Integer id, String name, double worktime, double base, String project, double part, double projectMoney ) {
        super(id, name, worktime, base);
        this.project = project;
        this.part = part;
        this.projectMoney = projectMoney;
        this.salary(worktime, base);
        this.bonus(projectMoney, part);
    }

    public
    void salary ( double worktime, double base ) {
        setPayment(worktime * base);
    }

    public
    void bonus ( double budget, double part ) {
        double bonus = budget * part;
        setPayment(this.getPayment() + bonus);
    }

}

class Programmer extends Engineer {

    public
    Programmer ( Integer id, String name, double worktime, double base, String project, double part, double projectMoney ) {
        super(id, name, worktime, base, project, part, projectMoney);
    }

}

class Tester extends Engineer {


    public
    Tester ( Integer id, String name, double worktime, double base, String project, double part, double projectMoney ) {
        super(id, name, worktime, base, project, part, projectMoney);
    }
}

class TeamLeader extends Engineer implements Heading {
    int count;
    public
    TeamLeader ( Integer id, String name, double worktime, double base, String project, double part, double projectMoney, int count ) {
        super(id, name, worktime, base, project, part, projectMoney);
        this.count = count;
        this.salary(base, count);
    }

    public
    void salary ( double base, int employeeNumber ) {
        setPayment(this.getPayment() + base * employeeNumber);
    }
}


