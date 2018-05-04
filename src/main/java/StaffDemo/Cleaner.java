package StaffDemo;

import java.util.ArrayList;

public class Cleaner extends Personal {

    public Cleaner(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }

    public Cleaner(String id, String surname, String name, String secondname) {
        super(id, surname, name, secondname);
    }

    public void calcPayment() {
        payment = calcPaymentWorkTime();
    }

    public double calcPaymentWorkTime() {
        return rateDayHours * dayWorkHours;
        }

    public static ArrayList<Cleaner> getCleaners(ArrayList<Employee> employees) {
        ArrayList<Cleaner> newArray = new ArrayList<Cleaner>();
        for(Employee next: employees){
            if (next.getClass().getSimpleName().equals("Cleaner")) {
                newArray.add((Cleaner) next);
            }
        }
        return newArray;
    }
}
