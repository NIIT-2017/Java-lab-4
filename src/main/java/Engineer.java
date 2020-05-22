abstract class Engineer extends Employee implements WorkTime, Project {
    private int base, worktime, budget, duration;
    private double share;

    abstract static class Builder <T extends Builder<T>> extends Employee.Builder<T>
    {
        private int base, worktime, budget, duration;
        private double share;
        public T base(int base) {
            this.base=base;
            return self();
        }
        public T worktime(int worktime) {
            this.worktime=worktime;
            return self();
        }
        public T budget(int budget) {
            this.budget=budget;
            return self();
        }
        public T duration(int duration) {
            this.duration=duration;
            return self();
        }
        public T share(double share) {
            this.share=share;
            return self();
        }
        abstract Engineer build();
        protected abstract T self();
    }
    Engineer(Builder <?> builder){
        super(builder);
        base = builder.base;
        worktime = builder.worktime;
        budget=builder.budget;
        duration=builder.duration;
        share=builder.share;
    }
    @Override
    public int worktimePayment() {
        return base * worktime/totalWorktime;
    }
    @Override
    public int projectPayment() {
        int payment = (int)(((double)budget/duration)*share);
        return payment;
    }
}
