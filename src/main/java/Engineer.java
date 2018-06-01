        abstract class Engineer extends Employee implements WorkTime, Project{


            public static int sumOfProject;
            public static int percentOfParticipate;
            String projectName;

            public Engineer(long id, String name, long workTime,
                            int base,int payment,int sumOfProject, int percentOfParticipate, String projectName ) {
                super(id,name,workTime,base,payment);
                this.sumOfProject=sumOfProject;
                this.percentOfParticipate=percentOfParticipate;
                this.projectName=projectName;
            }

            public String getProjectName() {
                return projectName;
            }

            public void setProjectName(String projectName) {
                this.projectName = projectName;
            }

            public int getSumOfProject() {
                return sumOfProject;
            }

            public void setSumOfProject(int sumOfProject) {
                this.sumOfProject = sumOfProject;
            }

            public int getPercentOfParticipate() {
                return percentOfParticipate;
            }

            public void setPercentOfParticipate(int percentOfParticipate) {
                this.percentOfParticipate = percentOfParticipate;
            }


            public abstract double payForProject();
            public abstract double payForHours();
        }
    class Programmer extends Engineer{


    public Programmer(long id, String name, long workTime,
                      int base ,int payment, int sumOfProject, int percentOfParticipate, String projectName) {

        super(id, name, workTime, base, payment, sumOfProject,percentOfParticipate, projectName);

    }

        public double payForProject() {
            return getSumOfProject()*getPercentOfParticipate()/100;
        }

        public double payForHours() {
            return getWorkTime()*getBase();
        }


        public double calcPayment() {
            return payForProject()+payForHours();
        }


    }

        class Tester extends Engineer {
//            int sumOfProject;
//            int percentOfParticipate;

            public Tester(long id, String name, long workTime,
                          int base ,int payment, int sumOfProject, int percentOfParticipate, String projectName){
                super(id, name, workTime, base, payment, sumOfProject, percentOfParticipate, projectName);

            }

            public double payForProject() {
                return getPercentOfParticipate()*getSumOfProject()/100;
            }

            public double payForHours() {
                return getWorkTime()*getBase();
            }

            public double calcPayment() {
                return payForProject()+payForHours();
            }
        }