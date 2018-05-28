import java.util.ArrayList;

public class Draft
{
    private String title;
    private double budget;
    private ArrayList<Integer> idEmployees;
    private int idProjManager;
    public Draft (String title, double budget) { //constructor of draft's (project's) exemplar
        this.title = title;
        this.budget = budget;
        this.idEmployees = new ArrayList<Integer>();
        this.idProjManager = 0;
    }
    public boolean addIdEmployee(int id) { //add employee's id to draft's arrayList "idEmployees"
        if (!checkIdEmployee(id)) {
            idEmployees.add(id);
            return true;
        }
        return false;
    }
    public boolean setIdProjManager(int id) { //set id of project manager
        if (checkIdEmployee(id)) {
            this.idProjManager = id;
            return true;
        }
        return false;
    }
    public String getTitle() { //get draft's title
        return title;
    }
    public double getBudget() { //get draft's budget
        return budget;
    }
    public int getIdProjManager() { //get draft's project manager's id
        return idProjManager;
    }
    public int getEmployeesCount() { //get count of draft's employees
        return idEmployees.size();
    }
    public ArrayList<Integer> getIdEmployees() { //get arrayList "idEmployees"
        return idEmployees;
    }
    public boolean checkIdEmployee(int id) { //check idEmployee in arrayList "idEmployees"
        if (!moreZero(id)) {
            return false;
        }
        if (checkIdEmployeesNotNull()) {
            for(int idVal : idEmployees) {
                if (id == idVal) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkIdEmployeesNotNull() { //check idEmployees is not null
        return (idEmployees != null);
    }
    private boolean moreZero(int id) { //check id (integer) more than zero
        return (id > 0);
    }
}
