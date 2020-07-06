import java.util.ArrayList;
import java.util.List;

public class Projects {

   private String name;
    private int cost;
    private int numberEngineer = 0;
    private int numberManager = 0;
    private List<Employee> employee = new ArrayList<Employee>();

     public int searchNumberEngineer() {
         for (int i = 0; i < employee.size(); i++) {
             if(employee.get(i) instanceof Engineer)
                 numberEngineer++;
         }
         return numberEngineer;
     }

    public int searchNumberManager() {
        for (int i = 0; i < employee.size(); i++) {
            if(employee.get(i) instanceof Manager)
                numberManager++;
        }
        return numberManager;
    }

    public int getNumberEngineer() {
        return numberEngineer;
    }

    public void setNumberEngineer(int numberEngineer) {
        this.numberEngineer = numberEngineer;
    }

    public int getNumberManager() { return numberManager;  }

    public void setNumberManager(int numberManager) {
        this.numberManager = numberManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}


