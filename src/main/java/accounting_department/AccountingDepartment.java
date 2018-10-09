package accounting_department;

import employee.Employee;
import employee.engineer.Tester;

import java.util.Collection;

public class AccountingDepartment implements WorkTime, Heading, Project {

    public double getPayment(Employee employee){
        double payment=0.0;

        if (employee.getPosition().equals("Уборщица")||employee.getPosition().equals("Водитель"))
            payment=getHourlyPay(employee);
        if (employee.getPosition().equals("Инженер по тестированию")||employee.getPosition().equals("Инженер-программист"))
            payment=getHourlyPay(employee)+getPaymentForProject(employee);
        if (employee.getPosition().equals("Менеджер"))
            payment=getPaymentForProject(employee);
        if (employee.getPosition().equals("Ведущий программист"))
            payment=getHourlyPay(employee)+getPaymentForProject(employee)+getPaymentForHeading(employee);
        if (employee.getPosition().equals("Проектный менеджер")||employee.getPosition().equals("Руководитель направления"))
            payment=getPaymentForProject(employee)+getPaymentForHeading(employee);

            return payment;
    }

    public double getHourlyPay(Employee employee) {
        return employee.getWorkTime()*employee.getBase();
    }

    public double getPaymentForHeading(Employee employee) {
        return employee.getSubordinates()*100000;
    }

    public double getPaymentForProject(Employee employee) {
        Collection<Double[]> val = employee.getProject().values();
        double payment=0;
        for (Double[] arr:val){
            payment=arr[0]*arr[1];
            //payment+=payment;
        }
        return payment;
    }

    public static void main(String[] args) {
        Employee engineer = new Tester();
        engineer.setWorkTime(10);
        engineer.setBase(10);
        engineer.setProject("StaffDemo", new Double[]{10.0, 1.0});
        engineer.setPosition("Инженер по тестированию");
        AccountingDepartment accountingDepartment = new AccountingDepartment();
        System.out.println(engineer.getProject().values());
        System.out.println(accountingDepartment.getPaymentForProject(engineer));
    }
}