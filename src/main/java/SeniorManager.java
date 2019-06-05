public class SeniorManager extends ProjectManager {

    public SeniorManager(int id, String name, String position, int base, int project, int numofsubord, double part) {
        super(id, name, position, base, project, numofsubord, part);
    }

    public void calc() {
        this.setPayment((proPyment(this.getProject(), this.getPart())) + hdPyment(this.getNumofsubord(), this.getBase()));
    }
}
