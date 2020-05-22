abstract class Personal extends Employee implements WorkTime{
    private int base, worktime;// really worked hours

    abstract static class Builder <T extends Builder<T>> extends Employee.Builder<T>
    {
        private int base, worktime;
        public T base(int base) {
            this.base=base;
            return self();
        }
        public T worktime(int worktime) {
            this.worktime=worktime;
            return self();
        }
        abstract Personal build();
        protected abstract T self();
    }
    Personal(Builder <?> builder){
        super(builder);
        base = builder.base;
        worktime = builder.worktime;
    }

    @Override
    public int worktimePayment() {
        return base * worktime/totalWorktime;
    }
}
