public class Manager extends Employee implements Project {
    private int budget, duration;
    private double share;
    public static class Builder extends Employee.Builder<Builder> {
        private int budget, duration;
        private double share;
        public Builder budget(int budget){
            this.budget=budget;
            return this;
        }
        public Builder duration(int duration){
            this.duration=duration;
            return this;
        }
        public Builder share(double share){
            this.share=share;
            return this;
        }
        @Override
        Manager build() {
            return new Manager(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }

    protected Manager(Builder builder) {
        super(builder);
        budget=builder.budget;
        duration=builder.duration;
        share=builder.share;
    }
    @Override
    public int projectPayment() {
        return (int)(((double)budget/duration)*share);
    }

    public void countPayment() {
        setPayment(projectPayment());
    }
}
