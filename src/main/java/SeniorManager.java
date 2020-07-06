public class SeniorManager extends ProjectManager {
    public static class Builder extends ProjectManager.Builder {
        @Override
        SeniorManager build() {
            return new SeniorManager(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }

    private SeniorManager(Builder builder) {
        super(builder);
    }

    @Override
    public void countPayment() {
        setPayment(headingPayment()+projectPayment());
    }
}
