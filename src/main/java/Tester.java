class Tester extends Engineer {
    Tester(int id, String name, double worktime, double payForHour, double bonus,String project){
        super(id,name,worktime,payForHour,bonus,project);
    }

    @Override
    double CalcPayment() {
        double pay=calcPaymentByWorkTime()+calcPaymentByProject();
        setPayment(pay);
        return pay;
    }
}