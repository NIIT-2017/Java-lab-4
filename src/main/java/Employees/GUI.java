package Employees;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GUI {
    static BufferedReader bufferedReader;
    static {
        bufferedReader =new BufferedReader(new InputStreamReader(System.in));
    }
    public static String loadCompanyFile() throws Exception
    {
        System.out.println("Enter company file location or empty string");

        return bufferedReader.readLine();
    }
    public static int enterOperation() throws Exception
    {
        System.out.println("Enter number of desired operation.\n" +
                           "1 - Print all salaries");
        return Integer.parseInt(bufferedReader.readLine());
    }
    public static void printSalary(int employeeId,Company company)
    {
        if(employeeId<0)
        {
            for (Project project : company.getProjects())
            {
                for(Employee employee:project.getEmployees())
                {
                    printSalary(employee);
                }
                for(Employee employee:company.getPersonal())
                {
                    printSalary(employee);
                }
            }
        }
    }
    public static void printSalary(Employee employee)
    {
        String stringStats=employee.getClass().getName()+" Name : "+employee.getName()+" Surname : "+employee.getSurname()+" Total_Salary : "
                +employee.getSalary();

        if(employee instanceof WorkTime)
        {
                WorkTime workTimeEmployee=((WorkTime)employee);
                stringStats += " SalaryForHour : " + workTimeEmployee.getSalaryForHour() + " Work_Time : " + workTimeEmployee.getWorkTime();
        }
        if(employee instanceof ProjectPayment)
        {
            ProjectPayment projectPaymentEmployee=((ProjectPayment)employee);
            stringStats+=" Salary_For_Participation : "+projectPaymentEmployee.getSalaryForParticipation();
        }
        if(employee instanceof Heading)
        {
            Heading headingEmployee=((Heading)employee);
            stringStats+=" Salary_For_Heading : "+headingEmployee.getSalaryForHeading()+" Salary_Per_Subordinate : "
                    +headingEmployee.getSalaryPerSubordinate();
        }
        System.out.println(stringStats);

    }
}
