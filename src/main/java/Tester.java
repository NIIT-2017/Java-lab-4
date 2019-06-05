public class Tester extends Engineer {
    public Tester(int id, String name, String position, int base, int project, double part){
        this.setId(id);
        this.setName(name);
        this.setPosition(position);
        this.setBase(base);
        this.setProject(project);
        this.setPart(part);
    }

    public void calc() {
        this.setPayment((wtPayment(this.getBase(),this.getWorktime()))+(proPyment(this.getProject(), this.getPart())));
    }

}
