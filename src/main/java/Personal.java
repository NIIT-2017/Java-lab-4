abstract   class Personal extends Employee implements WorkTime {
    Personal(long id, String name, long workTime, int base, int payment) {
        super(id, name, workTime, base, payment);
    }

    public double payForHours() {return 0;}
}