
    abstract class Employee {
        private long id;
        private String name;
        private long workTime;//отработанное время
        Double base;// отплата за час
        private int payment;


        Employee(long id, String name, long workTime, double base,int payment){
            this.id=id;
            this.name=name;
            this.workTime=workTime;
            this.base=base;
            this.payment=payment;

        }



        public long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public long getWorkTime() {
            return workTime;
        }

        public void setWorkTime(Long workTime) {
            this.workTime = workTime;
        }

        public int getPayment() {
            return payment;
        }

        public void setPayment(int payment) {
            this.payment = payment;
        }

        public double getBase() {
            return base;
        }

        public void setBase(Double base) {
            this.base = base;
        }

        abstract public double calcPayment();

    }


