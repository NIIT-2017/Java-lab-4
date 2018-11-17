class Tester extends Engineer {

    public Tester(long id, String name, long workTime, int base ,int payment, int sumOfProject,
                  int percentOfParticipate, String projectName){
        super(id, name, workTime, base, payment, sumOfProject, percentOfParticipate, projectName);
    }

    public double payForProject() {
        return getPercentOfParticipate() * getSumOfProject()/100;
    }
    public double payForHours() {
        return getWorkTime() * getBase();
    }
    public double calcPayment() {
        return payForProject() + payForHours();
    }
}