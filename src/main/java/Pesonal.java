abstract class Pesonal extends Employee implements WorkTime {
    protected double base;

    Pesonal(int id, String fio, int workTime, String position, double base){
        this.id = id;
        this.fio = fio;
        this.workTime = workTime;
        this.position = position;
        this.base = base;
    }

    protected void calculatePayment() {
        payment = workTimePayment();
    }

    public double workTimePayment() {
        return base * workTime;
    }
}

class Cleaner extends Pesonal{
    Cleaner(int id, String fio, int workTime, String position, double base){
        super(id, fio, workTime, position, base);
    }
}

class Driver extends Pesonal{
    Driver(int id, String fio, int workTime, String position, double base){
        super(id, fio, workTime, position, base);
    }
    @Override
    protected void calculatePayment(){
        payment = workTimePayment() * 1.3;
    }
}
