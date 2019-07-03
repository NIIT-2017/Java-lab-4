class Driver extends Personal {
    Driver(int id, String name, int base) {
        super(id, name, base);
    }

    public int WorktimePay() {
        return base * worktime + 2000;
    }

    public void calc() {
        setPayment(WorktimePay());
    }

}