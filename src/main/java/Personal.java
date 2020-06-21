public class Personal extends Employee implements WorkTime { //работник по найму с оплатой за фактически отработанное время. Имеет ставку за час.

    public int calculatePaymentWorkTime() {
       return worktime*base;
    }

    public void calculatePayment(int cost) {
        payment = calculatePaymentWorkTime();
    }

}
