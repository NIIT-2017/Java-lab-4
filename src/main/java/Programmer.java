class Programmer extends Engineer{
    Programmer(int id, String name, double workTime, double payForHour, double bonus, String project) {
        super(id, name, workTime, payForHour, bonus, project);
    }

    @Override
    double calcPayment(){
        double payment = calcPaymentByWorkTime() + calcPaymentByProject();
        setPayment(payment);
        return payment;
    }
}
