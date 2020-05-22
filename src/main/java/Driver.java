public class Driver extends Personal implements WorkTime{
    private int extraCharge;
    public static class Builder extends Personal.Builder<Builder>{
        private int extraCharge;
        public Builder extraCharge(int extraCharge){
            this.extraCharge=extraCharge;
            return this;
        }
        @Override
        Driver build() {
            return new Driver(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }

    private Driver(Builder builder) {
        super(builder);
        extraCharge=builder.extraCharge;
    }

    public void countPayment() {
        setPayment( worktimePayment()+extraCharge);
    }
}
