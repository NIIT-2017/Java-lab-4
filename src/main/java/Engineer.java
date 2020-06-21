class Engineer extends Employee implements WorkTime, Project  { //инженер. Имеет ставку и оплату за час + бонусы от выполняемого проекта.

    public int calculatePaymentWorkTime() {
        return worktime*base;
    }

    public int calculateProjectPayment (int cost) {
        return (int) (projectIndex*cost);
    }

    public void calculatePayment(int cost) {
        payment = calculatePaymentWorkTime()+calculateProjectPayment(cost);
    }

}