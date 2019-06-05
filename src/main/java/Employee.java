//Employee - работник. Основной родительский класс для всех разновидностей работников
//    id - идентификационный номер.     name - ФИО.
//    worktime - отработанное время.    payment - заработная плата.

 abstract public class Employee {
    private  String id;
    private  String fio;
    private double worktime;
    private  double payment;

    Employee(String id, String fio){
       this.id = id;
       this.fio=fio;
    }

    public String getId() {return id; }
    public String getFio() {return fio;}
    public double getWorktime() {return worktime;}
    public double getPayment() {return payment;}
    public void setPayment(double payment){this.payment = payment;}
    public void setWorktime(double worktime) {this.worktime = worktime;}

    abstract double Calc();


}
