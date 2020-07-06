public class Programmer extends Engineer implements WorkTime, Project {
    public static class Builder extends Engineer.Builder<Builder> {
        @Override
        Programmer build() {
            return new Programmer(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }

    protected Programmer(Builder builder) {
        super(builder);
    }

    public void countPayment() {
        setPayment(worktimePayment()+projectPayment());
    }
}
