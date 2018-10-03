package employee.personal;

import employee.Employee;

public class Personal extends Employee {
    @Override
    public String toString() {
        return super.toString() + "Ставка: " + super.getBase()+" Отработанное время: "+super.getWorkTime()+" Почасовая оплата: ";
    }
}