package StaffDemo;

import java.util.ArrayList;

public class Cleaner extends Personal {
    //конструктор для создания сначала
    public Cleaner(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }
    //конструктор для чтения из файла
    Cleaner(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }

    public void calcPayment() {
        payment = calcPaymentWorkTime();
    }
//    выделить из списка всех Cleaner
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
