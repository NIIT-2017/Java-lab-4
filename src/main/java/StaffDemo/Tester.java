package StaffDemo;

import java.util.ArrayList;
//тестировщик
public class Tester extends Enginer {
//консруктор для нового
    public Tester(String surname, String name, String secondname) {
        super(surname, name, secondname);
    }
//конструктор для чтения из файла
    Tester(String id, String surname, String name, String secondname) {
        super(surname, name, secondname);
        this.setID(Integer.parseInt(id));
    }
//расчет ЗП
    public void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentWorkTime();
    }
//сетеры и гетеры
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
