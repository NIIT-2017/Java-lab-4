abstract class Employee {
    private int id;
    private String name;
    private int worktime;
    private int payment;
    private String position;
    private int base;

    public abstract void calcSalary();

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setWorktime(int hours){
        this.worktime = hours;
    }

    public int getWorktime(){
        return worktime;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getPosition(){
        return position;
    }

    public void setBase(int base){
        this.base = base;
    }

    public int getBase(){
        return base;
    }

    public void setPayment(int payment){
        this.payment = payment;
    }

    public int getPayment(){
        return payment;
    }
}
