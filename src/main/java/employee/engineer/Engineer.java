package employee.engineer;

import employee.Employee;
import interfaces.WorkTime;
import interfaces.Project;

import java.util.Collection;

public class Engineer extends Employee implements WorkTime, Project{

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
            //payment+=payment;
        }
        return payment;
    }

    @Override
    public double getHourlyPay(Employee employee) {
        return getWorkTime()*getBase();
    }

    @Override
    public void payroll(){
        double payment = getHourlyPay(this)+ getPaymentForProject(this);
        super.setPayment(payment);
    }
}
