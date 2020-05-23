public class ProjectManager extends Manager implements Heading {
    private int subordinates, rate;
    public static class Builder extends Manager.Builder {
        private int subordinates, rate;
        public Builder subordinates(int subordinates){
            this.subordinates=subordinates;
            return self();
        }
        public Builder rate(int rate){
            this.rate=rate;
            return self();
        }
        @Override
        ProjectManager build() {
            return new ProjectManager(this);
        }
        @Override
        protected ProjectManager.Builder self() {
            return this;
        }
    }

    protected ProjectManager(ProjectManager.Builder builder) {
        super(builder);
        subordinates=builder.subordinates;
        rate=builder.rate;
    }
    @Override
    public int headingPayment() {
        return rate * subordinates;
    }

    public void countPayment(){
        setPayment(projectPayment()+headingPayment());
    }
}
