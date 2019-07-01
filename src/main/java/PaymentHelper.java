import java.util.ArrayList;

public class PaymentHelper {
    ArrayList<Employee> employees;

    public PaymentHelper(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public int calculateProjectPaymentPerHour(String project) {
        return calculateProjectBuget(project) / calculateTotalHoursProject(project);
    }

    private int calculateProjectBuget(String project){
        int buget = 0;
        for(Employee employee : employees){
            if((employee.position == Position.PROJECT_MANAGER || employee.position == Position.SENIOR_MANAGER)
                    && employee.project.equals(project)){
                buget = employee.budget;
            }
        }
        return buget;
    }

    private int calculateTotalHoursProject(String project){
        int totalHours = 0;
        for(Employee employee : employees) {
            if(employee.project != null && employee.project.equals(project)){
                totalHours += employee.workload;
            }
        }
        return totalHours;
    }

    public int calculateProjectCount(String project) {
        int count = 0;
        for(Employee employee : employees) {
            if (employee.project != null && employee.project.equals(project)) {
                count++;
            }
        }
        return count;
    }
}
