        class TeamLeader extends Programmer implements Heading{

            int numOfEmpl;
            int payForOneEmpl;

        public TeamLeader(long id, String name, long workTime,
                  int base ,int payment, int sumOfProject, int percentOfParticipate,
                          int numOfEmpl, int payForOneEmpl, String projectName) {

          super(id, name, workTime, base, payment, sumOfProject,percentOfParticipate,projectName);

         this.numOfEmpl=numOfEmpl;
         this.payForOneEmpl=payForOneEmpl;
        }

            public int getNumOfEmpl() {
                return numOfEmpl;
            }

            public void setNumOfEmpl(int numOfEmpl) {
                this.numOfEmpl = numOfEmpl;
            }

            public int getPayForOneEmpl() {
                return payForOneEmpl;
            }

            public void setPayForOneEmpl(int payForOneEmpl) {
                this.payForOneEmpl = payForOneEmpl;
            }

            public double payForProject() {
                return getSumOfProject()*getPercentOfParticipate()/100;
            }

            public double payForHours() {
                return getWorkTime()*getBase();
            }


            public double calcPayment() {
                return payForProject()+payForHours()+payForHeading();
            }

            public int payForHeading() {
               return getNumOfEmpl()*getPayForOneEmpl();
            }

        }