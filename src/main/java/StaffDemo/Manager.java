package StaffDemo;

import java.util.ArrayList;
//менеджер имеет только ставку за участие в проекте в котором участвует
public class Manager extends OfficePlankton implements PaymentForProject {
    private double ratePerProject;
//конструктор для нового менеджера
    public Manager(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }
//конструктор для чтения из файла
    Manager(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }
//расчет ЗП
    public void calcPayment() {
        payment = calcPaymentForPartOfProject();
    }
//расчет процента от бюджета проекта
    public double calcPaymentForPartOfProject() {
        if (this.getProject()==null) return 0.0;
        else return ratePerProject *this.getProject().getBudget();
    }
//сетеры и гетеры
    public void setRatePerProject(double ratePerProject) {
        this.ratePerProject = ratePerProject;
    }

    double getRatePerProject() {
        return ratePerProject;
    }

    public static ArrayList<Manager> getManagers(ArrayList<Employee> employees) {
        ArrayList<Manager> newArray = new ArrayList<Manager>();
        for(Employee next: employees){
            if (next.getClass().getSimpleName().equals("Manager")) {
                newArray.add((Manager) next);
            }
        }
        return newArray;
    }
}
