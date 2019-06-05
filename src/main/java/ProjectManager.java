public class ProjectManager extends Manager implements Heading {

    public ProjectManager(int id, String name, String position, int base, int project, int numofsubord, double part) {
        this.setId(id);
        this.setName(name);
        this.setPosition(position);
        this.setBase(base);
        this.setNumofsubord(numofsubord);
        this.setProject(project);
        this.setPart(part);
    }
    public void calc() {
        this.setPayment((proPyment(this.getProject(), this.getPart())) + hdPyment(this.getNumofsubord(), this.getBase()));
    }

    public int hdPyment(int numofsubord, int surcharge) {
        int hdpyment = numofsubord*surcharge;
        return hdpyment;
    }
}
