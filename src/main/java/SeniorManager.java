import java.util.HashMap;

public class SeniorManager extends ProjectManager{

    SeniorManager(long id, String name, HashMap<String, Double> mapProjectsPercent,int personal) {
        super(id, name,mapProjectsPercent,personal);
    }

    @Override
    public String toString(){
        return "SeniorManager";
    }
}
