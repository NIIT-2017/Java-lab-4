package employee.manager;

import employee.Employee;
import interfaces.Project;

import java.util.Collection;

public class Manager extends Employee implements Project {
    @Override
    public String toString() {
        return super.toString() + "Ставка: " + super.getBase() + " Зарплата: " + super.getPayment();
    }

    @Override
    public double getPaymentForProject(Employee employee) {

        Collection<Double[]> val = employee.getProject().values();
        double payment=0;
        for (Double[] arr:val){
            payment=arr[0]*arr[1];
        }
        return payment;
    }

    @Override
    public void payroll(){
        double payment = getPaymentForProject(this);
        setPayment(payment);
    }

}
