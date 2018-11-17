class Programmer extends Engineer{

    public Programmer(long id, String name, long workTime, int base ,int payment, int sumOfProject,
                      int percentOfParticipate, String projectName) {
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
