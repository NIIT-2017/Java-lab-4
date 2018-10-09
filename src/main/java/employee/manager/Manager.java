package employee.manager;

import employee.Employee;

public class Manager extends Employee {
    @Override
    public String toString() {
        return super.toString() + "Ставка: " + super.getBase() + " Зарплата: " + super.getPayment();
    }
}
