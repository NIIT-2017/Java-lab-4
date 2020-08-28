package Staff;

class Tester extends Engineer{

    //constructor
    public Tester(int id, String fio, int workTime, DeveloperCompany company) {
        super(id, fio, workTime, company);
        position = "Tester";
    }
    //---------------------------------------------------------

    //methods
    @Override
    public double hourlyPay() {
        double skillRating= 1.7;
        return baseRate*skillRating*workTime;
    }
    //---------------------------------------------------------
}
