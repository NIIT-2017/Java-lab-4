public class Driver extends Personal{
    public Driver(int id, String name, String position, int base){
        this.setId(id);
        this.setName(name);
        this.setPosition(position);
        this.setBase(base);
    }

    public void calc() {
        this.setPayment(wtPayment(this.getBase(),this.getWorktime()));
    }


}
