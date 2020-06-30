import java.util.Map;

public class SeniorManager extends Employee implements Heading {
    private Integer count;
    public SeniorManager(int id, String name, Integer count){
        this.id = id;
        this.name = name;
        this.count = count;
    }

    @Override
    public void calc() {
        Double result = result(count);
        for(Map.Entry<String, Double> entry : Project.projects.entrySet()){
            result += entry.getValue()*0.05;
        }
        this.payment = result;
    }

    @Override
    public Double result(Integer count) {
        return count * 1000.0;
    }
}
