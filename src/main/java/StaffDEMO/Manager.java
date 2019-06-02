package StaffDEMO;

public
abstract
class Manager extends Employee implements Project{
    double part;
    double price;
    double base;
    int count;
    String project;
    double projectMoney;

    public
    Manager ( Integer id, String name, double worktime, double price, double base, double part, String project, int count, double projectMoney ) {
        super(id, name, worktime, price);
        this.part = part;
        this.base = base;
        this.project = project;
        this.count = count;
        this.projectMoney = projectMoney;
        this.bonus(projectMoney, part);
    }


    public
    void bonus ( double budget, double part ) {
        setPayment(budget * part);
    }
}

class ProjectManager extends Manager implements Heading {
    public
    ProjectManager ( Integer id, String name, double worktime, double price, double base, double part, String project, int count, double projectMoney ) {
        super(id, name, worktime, price, base, part, project, count, projectMoney);
        this.salary(price, count);
    }

    public
    void salary ( double base, int employeeNumber ) {
        double bonus = base * employeeNumber;
        setPayment(getPayment() + bonus);
    }
}

class SeniorManager extends ProjectManager{

    public
    SeniorManager ( Integer id, String name, double worktime, double price, double base, double part, String project, int count, double projectMoney ) {
        super(id, name, worktime, price, base, part, project, count, projectMoney);
        this.salary(price, count);
    }
}
