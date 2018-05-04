package StaffDemo;

import java.util.ArrayList;

public class Tester extends Enginer {

    public Tester(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public Tester(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }

    public void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentWorkTime();
    }

    public static ArrayList<Tester> getTesters(ArrayList<Employee> employees) {
        ArrayList<Tester> newArray = new ArrayList<Tester>();
        for(Employee next: employees){
            if (next.getClass().getSimpleName().equals("Tester")) {
                newArray.add((Tester) next);
            }
        }
        return newArray;
    }
}
