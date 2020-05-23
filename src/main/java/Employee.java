public abstract class Employee {
    private int id;
    private String name;
    private String position;
    private int payment;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public int getPayment() {
        return payment;
    }

    protected void setPayment(int payment) {
        this.payment = payment;
    }
    abstract void countPayment();

    abstract static class Builder <T extends Builder <T>>
    {
        private int id;
        private String name;
        private String position;
        public T newEmployee(int id, String name, String position) {
            this.id=id;
            this.name = name;
            this.position = position;
            return self();
        }
        abstract Employee build();
        protected abstract T self();
    }
    Employee(Builder<?> builder){
        id = builder.id;
        name = builder.name;
        position = builder.position;
    }
}
