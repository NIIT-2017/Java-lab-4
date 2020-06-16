import java.util.HashMap;

public class Programmer extends Engineer{

    public Programmer(long id, String name,double base,HashMap<String, Double> mapProjectsPercent) {
        super(id, name,base,mapProjectsPercent);
    }

    double calc() {
        payment= calcWork(workTime)+calcProject(mapProjectsPercent);
        return payment;
    }

    public String toString(){
        return "Programmer";
    }
}
