//Pesonal - работник по найму с оплатой за фактически отработанное время.
//Имеет ставку за час.

 abstract class Personal extends Employee implements Worktime {
    private double base;
    Personal(String id, String fio, double base){
        super(id, fio);
        this.base = base;
    }

     public double getBase() {return base;}

     public double WtCalc(){
         setPayment( this.base*getWorktime() );
         return( getPayment() );
    };
     public double Calc(){
         return this.WtCalc();
     }
}
