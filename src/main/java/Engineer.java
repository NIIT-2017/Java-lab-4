abstract public class Engineer extends Employee implements WorkTime, Project {
    Engineer(){
        super();
    }
    Engineer(int id, String name, int worktime, int payment){
        super(id, name, worktime, payment);
    }
}
