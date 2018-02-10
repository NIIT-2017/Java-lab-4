
//        id - идентификационный номер.
//        name - ФИО.
//        worktime - отработанное время.
//        payment - заработная плата.
//        Заработная плата работникам начисляется, исходя из должности, почасовой ставки и участию в проектах.

public class Employee {

    protected int id;
    protected String name;
    protected String position;
    protected int time;
    protected int payment;

    Employee(int id, String name, String position){
        this.id = id;
        this.name = name;
        this.position = position;
        this.payment = 0;
    }
    public void addTime(int time){
        this.time += time;
    }

    public void totalPayment(){

    }
}
