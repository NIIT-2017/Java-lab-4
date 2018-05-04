package StaffDemo;

import java.util.ArrayList;

class Manager extends OfficePlankton implements PaymentForProject {
    private double rate;

    public Manager(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public Manager(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }

    public void calcPayment() {
        payment = calcPaymentForPartOfProject();
    }

    public double calcPaymentForPartOfProject() {
        if (this.getProject()==null) return 0.0;
        else return rate*this.getProject().getBudget();
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    double getRate() {
        return rate;
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
