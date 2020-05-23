public class TeamLeader extends Programmer implements Heading {
    int subordinates, rate;

    public static class Builder extends Programmer.Builder {
        int subordinates, rate;
        public TeamLeader.Builder subordinates(int subordinates) {
            this.subordinates=subordinates;
            return this;
        }
        public TeamLeader.Builder rate(int rate) {
            this.rate=rate;
            return this;
        }
        @Override
        TeamLeader build() {
            return new TeamLeader(this);
        }
        @Override
        protected TeamLeader.Builder self() {
            return this;
        }
    }

    private TeamLeader(Builder builder) {
        super(builder);
        subordinates=builder.subordinates;
        rate=builder.rate;
    }

    @Override
    public int headingPayment() {
        return rate * subordinates;
    }

    public void countPayment(){
        setPayment(worktimePayment()+projectPayment()+headingPayment());
    }
}
