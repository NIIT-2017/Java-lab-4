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