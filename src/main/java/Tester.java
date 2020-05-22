public class Tester extends Engineer implements WorkTime, Project{
    public static class Builder extends Engineer.Builder<Builder> {
        @Override
        Tester build() {
            return new Tester(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }

    private Tester(Builder builder) {
        super(builder);
    }

    public void countPayment() {
        setPayment(worktimePayment()+projectPayment());
    }
}
