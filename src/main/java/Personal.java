public abstract class Personal extends Employee implements WorkTime {

    Personal(int id, String name, String position) {
        super(id, name, position);
    }

    public int calculateWorktimeSalary(){
        int payment = 0;
        return payment;
    }

}

