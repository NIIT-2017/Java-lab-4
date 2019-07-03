class Cleaner extends Personal {
    public Cleaner(int id, String name, int base) {
        super(id, name, base);
    }

    public int WorktimePay() {
        return base * worktime;
    }

    public void calc() {
        setPayment(WorktimePay());
    }
}