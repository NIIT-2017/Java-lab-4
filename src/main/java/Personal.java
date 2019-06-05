abstract class Personal extends Employee implements WorkTime {
    public int wtPayment(int base, int hours) {
        int wtpayment = base*hours;
        return wtpayment;
    }
}
