class ProjectManager extends Manager implements Heading {
    protected int workers;
    double part = 0.5;

    ProjectManager(int id, String name, String pname, int workers) {
        super(id, name, pname);
        this.workers = workers;
    }

    public int HeadingPay(int workers) {
        return workers * 1000;
    }

    @Override
    public void calc() {
        setPayment(super.ProjectPay() + HeadingPay(this.workers));
    }
}