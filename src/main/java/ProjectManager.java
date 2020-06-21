class ProjectManager extends Manager implements Heading { //проектный менеджер

   // int numberEmployee;

    public int calculateHeadingManagerPayment(int numberManager) {
        return (int) ((numberManager-2)*1000);
    }

    public int calculateHeadingEngineerPayment(int numberEngineer) {
        return (int) ((numberEngineer)*1000);
    }

    public int calculatePayment (int cost, int numberManager, int numberEngineer) {
        return calculateHeadingEngineerPayment(numberEngineer) + calculateHeadingManagerPayment(numberManager) + calculateProjectPayment(cost);
    }

}