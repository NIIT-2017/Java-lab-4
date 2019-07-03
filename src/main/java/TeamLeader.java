class TeamLeader extends Programmer implements Heading {
    protected int workers; //кол-во подчиненных

    TeamLeader(int id, String name, int b, String pname, int workers) {
        super(id, name, b, pname);
        part = 0.3;
        this.workers = workers;
    }

    public int HeadingPay(int workers) {
        return this.workers * 5000;
    }

    @Override
    public void calc() {
        setPayment(HeadingPay(this.workers) + super.WorktimePay() + super.ProjectPay());
    }
}