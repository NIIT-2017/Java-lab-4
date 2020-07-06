public class Driver extends Personal{

    private int countWeekendTripsHours; //[hours]

    public Driver(long id, String name,double base, int countWeekendTripsHours) {
        super(id, name,base);
        this.countWeekendTripsHours=countWeekendTripsHours;
    }

    public int getCountWeekendTripsHours(){
        return countWeekendTripsHours;
    }

    public void setCountWeekendTripsHours(int hours){
        this.countWeekendTripsHours=hours;
    }

    public double allowance(int countWeekendTripsHours){
        return (0.1*countWeekendTripsHours*base);  //hourlyRate;
    }

    public double calc(){
        payment=calcWork(workTime)+allowance(countWeekendTripsHours);
        return payment;
    }

    public String toString(){
        return "Driver";
    }
}
