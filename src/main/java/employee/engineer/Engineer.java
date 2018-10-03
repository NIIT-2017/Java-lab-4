package employee.engineer;

import employee.Employee;

public class Engineer extends Employee {
    @Override
    public String toString() {
        return super.toString() + "Ставка: " + super.getBase() + " Зарплата: " + super.getPayment();
    }
}
