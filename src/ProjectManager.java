public class ProjectManager extends Manager implements Heading {
    public ProjectManager(int id, String name, int worktime, float payment, float projectShare){
        super(id, name, worktime, payment,projectShare);
    }

    public float calculateSalaryForProject() {
        return this.getProjectShare();
    }

    public float calculateSalaryForHeading(){
        return Main.employeesCount*10000;
    }

    public float calculateSalary(){
        return this.calculateSalaryForProject()+this.calculateSalaryForHeading();
    }

}
