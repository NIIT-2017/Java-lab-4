abstract class Employee {
    protected int id;
    protected String fio;
    protected double payment;
    protected int workTime;
    protected String position;

    protected abstract void calculatePayment();

    protected int getId() {
        return id;
    }

    protected String getFio() {
        return fio;
    }

    protected double getPayment() {
        return payment;
    }

    protected String getPosition() {
        return position;
    }
}
