import java.util.HashMap;

public abstract class Engineer extends Employee
        implements WorkTime, Project {

    protected double base; //for object implements WorkTime
    protected HashMap<String, Double> mapProjectsPercent=new HashMap <String, Double>(); //<Project, Percent> for object implements Project

    Engineer(long id, String name, double base,HashMap<String, Double> mapProjectsPercent) {
        super(id, name);
        this.base=base;
        this.mapProjectsPercent=mapProjectsPercent;
    }

    public double getBase(){
        return base;
    }

    public void setBase(double base){
        this.base=base;
    }

    public HashMap<String, Double> getMapProjectsPercent(){
        return mapProjectsPercent;
    }

    public double calcWork(int workTime){
        return 0.01*(double)workTime*base;
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

}
