import java.util.HashMap;

public class ProjectManager extends Manager
        implements Heading{

    protected int personal;

    ProjectManager(long id, String name, HashMap<String, Double> mapProjectsPercent,int personal) {
        super(id, name,mapProjectsPercent);
        this.personal=personal;
    }


    public int getPersonal(){
        return personal;
    }
    public void setPersonal(int personal){
        this.personal=personal;
    }

    public double calcHeading(int personal) {
        return (paymentPersonal*personal)*workTime/160;
    }

    @Override
    double calc() {
        payment= calcProject(mapProjectsPercent)+calcHeading(personal);
        return payment;
    }

    @Override
    public String toString(){
        return "ProjectManager";
    }
}