class Manager extends Employee implements Project {
    protected String ProjectName;
    protected double part;

    Manager(int id, String name, String pname) {
        super(id, name);
        this.part = 0.4;
        this.ProjectName = pname;
    }

    public int ProjectPay() {
        switch (ProjectName) {
            case "Project1":
                return (int) (project1 * part);
            case "Project2":
                return (int) (project2 * part);
            case "Project3":
                return (int) (project3 * part);
            default:
                return 0;
        }
    }

    public void calc() {
        setPayment(ProjectPay());
    }

}