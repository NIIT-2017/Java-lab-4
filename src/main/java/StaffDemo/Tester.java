package StaffDemo;

import java.util.ArrayList;

public class Tester extends Enginer {
    private ArrayList<Work> works;

    public Tester(String surname, String name, String secondname) {
        super(surname, name, secondname);
        works = new ArrayList<Work>();
    }

    public Tester(String id, String surname, String name, String secondname) {
        super(id, surname, name, secondname);
        works = new ArrayList<Work>();
    }

    public void addWorks(Project project, double part) {
        works.add(new Work(project, part));
    }

    public void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentWorkTime();
    }

    public double calcPaymentWorkTime() {
        return rate * workTime;
    }

    public static ArrayList<Tester> getTesters(ArrayList<Employee> employees) {
        ArrayList<Tester> newArray = new ArrayList<Tester>();
        for(Employee next: employees){
            if (next.getClass().getSimpleName().equals("ProjectManager")) {
                newArray.add((Tester) next);
            }
        }
        return newArray;
    }

    public double calcPaymentForPartOfProject() {
        double summ = 0.0;
        for (Work work : works) {
            summ+= work.project.allotMoney(work.part*work.project.getBudget());
        }
        return summ;
    }

    class Work{

        Project project;
        double part;

        Work(Project project, double part) {
            this.project = project;
            this.part = part;
        }
    }
}
