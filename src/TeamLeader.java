public class TeamLeader extends Programmer implements Heading{


    public TeamLeader(int id, String name, int worktime, float payment,float projectShare){
        super(id, name, worktime, payment,projectShare);
    }


    public float calculateSalaryForHeading(){
        return Main.employeesCount*10000;
    }

    @Override
    public float calculateSalaryForProject() {
        return this.getProjectShare();
    }

    public float calculateSalary(){
        return this.calculateSalaryForHeading()+this.calculateSalaryForProject();
    }
}
