class SeniorManager extends ProjectManager {
    SeniorManager(int id, String name, String pname, int workers) {
        super(id, name, pname, workers);
    }

    @Override
    public int HeadingPay(int workers) {
        return workers * 3000;
    }

    @Override
    public int ProjectPay() {
        return (int) ((project1 + project2 + project3) * this.part);
    }
}