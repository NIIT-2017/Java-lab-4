class Manager extends Employee implements Project { // менеджер. Оплату получает из денег проекта, которым руководит.

    public int calculateProjectPayment (int cost) {
        return (int) (projectIndex*cost);
    }

    public void calculatePayment(int cost) {
        payment = calculateProjectPayment(cost);
    }

}