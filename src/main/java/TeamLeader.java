class TeamLeader extends Programmer implements Heading { //ведущий программист

    int numberEmployee;

    public int calculateHeadingEngineerPayment(int numberEngineer) {
        return (int) ((numberEngineer-1)*projectIndex);
    }

    public int calculatePayment (int cost, int numberEngineer) {
        return calculateHeadingEngineerPayment(numberEngineer) + calculateProjectPayment(cost);
    }

    public int calculateHeadingManagerPayment(int numberManager) {
       return 0;
    }

}