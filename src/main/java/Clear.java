public class Clear extends Personal{

    public Clear(long id, String name, double base) {
        super(id, name, base);
    }

    public double calc(){
        payment=calcWork(getWorkTime());
        return payment;
    }

    public String toString(){
        return "Clear";
    }
}
