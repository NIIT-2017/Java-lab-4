class SeniorManager extends ProjectManager { //руководитель направления

    public int calculateHeadingManagerPayment(int numberManager) {
        return (int) ((numberManager-2)*1000);
    }

}