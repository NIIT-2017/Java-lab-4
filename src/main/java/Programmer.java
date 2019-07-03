class Programmer extends Engineer {
    Programmer(int id, String name, int b, String pname) {
        super(id, name);
        base = b;
        ProjectName = pname;
        part = 0.1;
    }

    public int WorktimePay() {
        return worktime * base;
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
        setPayment(WorktimePay() + ProjectPay());
    }
}