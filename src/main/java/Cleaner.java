public class Cleaner extends Personal implements WorkTime {

    public static class Builder extends Personal.Builder<Builder> {
        @Override
        Cleaner build() {
            return new Cleaner(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }

    private Cleaner(Builder builder) {
        super(builder);
    }

    @Override
    public void countPayment() {
        setPayment(worktimePayment());
    }
}

