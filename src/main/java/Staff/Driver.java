package Staff;

public class Driver extends Personal {

    //fields
    private double raisingFactor = 1.2;
    //---------------------------------------------------------

    //constructor
    public Driver(int id, String fio, int workTime, DeveloperCompany company) {
        super(id, fio, workTime, company);
        position = "Driver";
    }
    //---------------------------------------------------------

    //methods
    @Override
    public double hourlyPay() {
        if (workTime >= 160){
            return ((160+(workTime-160)*2)*baseRate*raisingFactor);
        }
        else
            return super.hourlyPay()*raisingFactor;
    }
    public void changeRaisingFactor(double raisingFactor){
        this.raisingFactor = raisingFactor;
    }
    //---------------------------------------------------------
}