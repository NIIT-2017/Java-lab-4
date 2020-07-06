import java.util.HashMap;

public class Tester extends Engineer{

    private double percentCode;

    public Tester(long id, String name, double base, HashMap<String, Double> mapProjectsPercent,double percentCode) {
        super(id, name,base,mapProjectsPercent);
        this.percentCode=percentCode;
    }

    public double getPercentCode(){
        return percentCode;
    }

    public void setPercentCode(double percentCode){
        this.percentCode=percentCode;
    }

    double qualityCode(double percentCode){
        return 1.3*percentCode*base;
    }

    double calc() {
        payment= calcWork(getWorkTime())+calcProject(mapProjectsPercent)+qualityCode(percentCode);
        return payment;
    }

    public String toString(){
        return "Tester";
    }
}
