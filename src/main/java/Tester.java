public class Tester extends Engineer{

    Tester(int id, String name, String position, int base, int project, double part){
        this.setId(id);
        this.setName(name);
        this.setPosition(position);
        this.setBase(base);
        this.setProject(project);
        this.setPart(part);
    }

    @Override
    public void calcSalary() {
        this.setPayment(wtCalc(this.getWorktime(), this.getBase()) +
                prjPayment(this.getProject(), this.getPart()));
    }
}
