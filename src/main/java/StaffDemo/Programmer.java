package StaffDemo;

import java.util.ArrayList;
public class Programmer extends Enginer {

    private ArrayList<Work> projects;

    public Programmer(String surname, String name, String secondname) {
        super(surname, name, secondname);
        projects = new ArrayList<Work>();
    }

    public void addWork(Project project, Double part) {
        Work work = new Work(project, part);
        projects.add(work);
    }

    public void calcPayment() {
        payment = calcPaymentForPartOfProject() + calcPaymentWorkTime();
    }

    public double calcPaymentForPartOfProject() {
        double summ=0.0;
        for (Work next : projects) {
            double money = next.part * next.project.budget;
            summ += next.project.allotMoney(money);
        }
        return summ;
    }

    public double calcPaymentWorkTime() {
        return workTime*rate;
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
