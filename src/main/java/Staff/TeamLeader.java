package Staff;

class TeamLeader extends Engineer implements Heading{

    //constructor
    public TeamLeader(int id, String fio, int workTime, DeveloperCompany company) {
        super(id, fio, workTime, company);
        position = "Team Leader";
    }
    //---------------------------------------------------------

    //methods
    @Override
    public double salaryCalculator() {
        return hourlyPay()+projectPayment()*managementFee(project);
    }
    @Override
    public double hourlyPay() {
        double skillRating= 2;
        return baseRate*skillRating*workTime;
    }
    public double managementFee(DevelopProjects project) {
        if (project != null) {
            double surcharge = 1 + (project.getEngineers().size() * 5) / 100;
            if (surcharge >= 1.5)
                surcharge = 1.5;
            return surcharge;
        }
        else
            return 1;
    }
    //---------------------------------------------------------
}