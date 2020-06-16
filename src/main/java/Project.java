import java.util.HashMap;

public interface Project {

    HashMap<String, Double> mapProjectsBudget = new HashMap<String, Double>(){{   //static and final

        put("Operation monitoring of a resource", 4238746.35);
        put("Unmanned control", 3735746.3);
        put("Workshop planning", 3005462.3);
        put("Internet of things in production", 967841.23);
        put("Online store", 475893.77);
    }};

    double calcProject(HashMap<String, Double> mapProjectsPercent);  //accept, that the coefficients are
}                                                                    //set over a period of time = workTime

