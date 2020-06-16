import java.util.HashMap;

public class Manager extends Employee
        implements Project {

    protected HashMap<String, Double> mapProjectsPercent=new HashMap <String, Double>();//<Project, Percent> for object implements Project

    Manager(long id, String name,HashMap<String, Double> mapProjectsPercent) {
        super(id, name);
        this.mapProjectsPercent=mapProjectsPercent;
    }

    public HashMap<String, Double> getMapProjectsPercent(){
        return mapProjectsPercent;
    }


    public double calcProject(HashMap<String, Double> mapProjectsPercent) {
        double projectCash=0;
        for(String projectEng:mapProjectsPercent.keySet()) {
            for(String projectAll:mapProjectsBudget.keySet()){
                if(projectEng.equals(projectAll))
                    projectCash+=(mapProjectsPercent.get(projectEng)*mapProjectsBudget.get(projectAll));
            }
        }

        return projectCash;
    }

    double calc() {
        payment=calcProject(mapProjectsPercent);
        return payment;
    }

    public String toString(){
        return "Manager";
    }
}
