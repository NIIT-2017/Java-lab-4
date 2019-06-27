public class Driver extends Personal {

    Driver(int id, String name, String position, int base){
        this.setId(id);
        this.setName(name);
        this.setPosition(position);
        this.setBase(base);
    }

    @Override
    public void calcSalary() {
        this.setPayment(wtCalc(this.getWorktime(), this.getBase()));
    }
}
